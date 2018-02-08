package co.melondev.cubedpay;

import co.melondev.cubedpay.data.User;
import co.melondev.cubedpay.envelope.APIEnvelopeTransformerConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author theminecoder
 */
public interface CubedPayAPI {

    public static CubedPayAPI create(String apiToken, String appId) {
        return create(apiToken, appId, "https://api.cubedpay.com");
    }

    public static CubedPayAPI create(String apiToken, String appID, String apiUrl) {
        return new Retrofit.Builder()
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
                                .addHeader("App-ID", appID)
                                .url(chain.request().url().newBuilder().addQueryParameter("access_token", apiToken).build())
                                .build()))
                        .build())
                .build().create(CubedPayAPI.class);
    }

    @GET("/user")
    CompletableFuture<User> getCurrentUser();

    @GET("/v1/shop/?page={page}&perpage={perpage}")
    CompletableFuture<List<String>> getShops(@Query("page") int page, @Query("perpage") int perpage);

    @GET("/v1/payment/request")
    CompletableFuture<String> requestPayment(@Query("shop_id") int shopId, @Query("items") Map<String, Double> items, @Query("amount") double amount, @Query("type") String type);

}
