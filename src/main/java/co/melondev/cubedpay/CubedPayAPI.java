package co.melondev.cubedpay;

import co.melondev.cubedpay.data.*;
import co.melondev.cubedpay.envelope.APIEnvelopeTransformerConverterFactory;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author theminecoder
 */
public interface CubedPayAPI {

    class DispatcherMap {
        private static final Map<CubedPayAPI, Dispatcher> dispatcherMap = new HashMap<>();
    }

    CubedPayStaticData data = new CubedPayStaticData();
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    static CubedPayAPI create(String appID) {
        return create(appID, "https://api.cubedpay.com");
    }

    static CubedPayAPI create(String appID, String apiUrl) {
        data.setAppID(appID);
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
                                .addHeader("app-id", data.getAppID())
                                .url(chain.request().url().newBuilder().addQueryParameter("access_token", data.getOAuth()).build())
                                .build())
                        ).dispatcher(dispatcher).build()
                ).build().create(CubedPayAPI.class);
        DispatcherMap.dispatcherMap.put(api, dispatcher);
        executor.schedule(new OAuthRefreshRunnable(api), 12, TimeUnit.HOURS);
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

    @GET("/payment/request")
    CompletableFuture<String> requestPayment(@Query("shop_id") int shopId, @Query("items") Map<String, Double> items, @Query("amount") double amount, @Query("type") String type);

    @GET("/game")
    CompletableFuture<Games> getGames(@Query("page") int page, @Query("perpage") int perpage);

    @GET("/global/permissions")
    CompletableFuture<Permissions> getPermissions(@Query("page") int page, @Query("perpage") int perpage);

    default void shutdown() throws InterruptedException {
        Dispatcher dispatcher = DispatcherMap.dispatcherMap.remove(this);
        dispatcher.cancelAll();
        dispatcher.executorService().shutdown();
        dispatcher.executorService().awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
