package co.melondev.cubedpay;

import co.melondev.cubedpay.data.*;
import co.melondev.cubedpay.envelope.APIEnvelopeTransformerConverterFactory;
import co.melondev.cubedpay.event.CubedAnnotationProcessor;
import co.melondev.cubedpay.event.CubedEvent;
import co.melondev.cubedpay.event.CubedEventRunnable;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public interface CubedPayAPI {

    class DispatcherMap {
        private static final Map<CubedPayAPI, Dispatcher> dispatcherMap = new HashMap<>();
    }

    class EventMap {
        private static final Map<String, ExecutorService> eventMap = new HashMap<>();
        private static CubedAnnotationProcessor annotationProcessor = new CubedAnnotationProcessor();
    }

    static CubedPayAPI create(String appID, String accessToken) {
        return create(appID, accessToken, "https://api.cubedpay.com");
    }

    static CubedPayAPI create(String appID, String accessToken, String apiUrl) {
        Dispatcher dispatcher = new Dispatcher();
        CubedPayAPI api = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(new Converter.Factory() {
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return super.responseBodyConverter(type, annotations, retrofit);
                    }
                })
                .addConverterFactory(new APIEnvelopeTransformerConverterFactory(GsonConverterFactory.create()))
                .addCallAdapterFactory(Java8CallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(chain -> chain.proceed(chain.request().newBuilder()
                                .addHeader("app-id", appID)
                                .url(chain.request().url().newBuilder().addQueryParameter("access_token", accessToken).build())
                                .build())
                        ).dispatcher(dispatcher).build()
                ).build().create(CubedPayAPI.class);
        DispatcherMap.dispatcherMap.put(api, dispatcher);
        return api;
    }

    @GET("/user")
    CompletableFuture<User> getCurrentUser();

    @POST("/auth/basic")
    CompletableFuture<LoginUser> login(@Query("username") String username, @Query("password") String password, @Query("ip") String ip, @Query("fingerprint") String fingerprint);

    @POST("/oauth/request")
    CompletableFuture<OAuthRequest> requestOAuth(@Query("scopes") List<String> scopes);

    @POST("/oauth/token")
    CompletableFuture<LoginUser> getAccessToken(@Query("token") String token);

    @POST("/oauth/refresh")
    CompletableFuture<LoginUser> refreshOAuth();

    @GET("/shop")
    CompletableFuture<List<String>> getShops(@Query("page") int page, @Query("perpage") int perpage);

    @GET("/game")
    CompletableFuture<Games> getGames(@Query("page") int page, @Query("perpage") int perpage);

    @GET("/global/permissions")
    CompletableFuture<Permissions> getPermissions(@Query("page") int page, @Query("perpage") int perpage);

    @GET("/shop/{sid}/event")
    CompletableFuture<Event> getEvent(@Path("sid") String shopId);

    @POST("/shop/{sid}/event/{eid}/ack")
    CompletableFuture<EventAccept> acceptEvent(@Path("sid") String shopId, @Path("eid") int eventId);

    @Multipart
    @POST("/payment/request")
    CompletableFuture<Payment> requestPayment(@Query("shop_id") String shopId, @Part("items") List<Item> items, @Query("type") String type);

    default void registerListener(Object clazz) {
        EventMap.annotationProcessor.processAnnotation(clazz);
    }

    default void startEvents(String shopID) {
        if (EventMap.eventMap.containsKey(shopID)) return;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(new CubedEventRunnable(this, shopID), 20, TimeUnit.SECONDS);
        EventMap.eventMap.put(shopID, executor);
    }

    default void emitEvent(CubedEvent event) {
        EventMap.annotationProcessor.emitEvent(event);
    }

    default void shutdown() throws InterruptedException {
        Dispatcher dispatcher = DispatcherMap.dispatcherMap.remove(this);
        dispatcher.cancelAll();
        dispatcher.executorService().shutdown();
        dispatcher.executorService().awaitTermination(10, TimeUnit.SECONDS);
        for (ExecutorService executor : EventMap.eventMap.values()) {
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
