package co.melondev.cubedpay;

import co.melondev.cubedpay.data.LoginUser;
import co.melondev.cubedpay.data.User;
import co.melondev.cubedpay.envelope.APIEnvelopeTransformerConverterFactory;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author theminecoder
 */
public interface CubedPayAPI {

    class DispatcherMap {
        private static final Map<CubedPayAPI, Dispatcher> dispatcherMap = new HashMap<>();
    }

    CubedPayStaticData data = new CubedPayStaticData();

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
                                .build()))
                        .dispatcher(dispatcher)
                        .build())
                .build().create(CubedPayAPI.class);
        DispatcherMap.dispatcherMap.put(api, dispatcher);
        return api;
    }

    @GET("/user")
    CompletableFuture<User> getCurrentUser();

    @POST("/auth/basic")
    CompletableFuture<LoginUser> login(@Query("username") String username, @Query("password") String password, @Query("ip") String ip, @Query("fingerprint") String fingerprint);

    @POST("/oauth/refresh")
    CompletableFuture<LoginUser> refresh();

    @GET("/shop/?page={page}&perpage={perpage}")
    CompletableFuture<List<String>> getShops(@Query("page") int page, @Query("perpage") int perpage);

    @GET("/payment/request")
    CompletableFuture<String> requestPayment(@Query("shop_id") int shopId, @Query("items") Map<String, Double> items, @Query("amount") double amount, @Query("type") String type);

    default void shutdown() throws InterruptedException {
        Dispatcher dispatcher = DispatcherMap.dispatcherMap.remove(this);
        dispatcher.cancelAll();
        dispatcher.executorService().shutdownNow();
        dispatcher.executorService().awaitTermination(10, TimeUnit.SECONDS);
    }

}
