package co.melondev.cubedpay;

import co.melondev.cubedpay.api.CubedPayShopAPI;
import co.melondev.cubedpay.api.CubedPayUserAPI;
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

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CubedPayAPI {

    private CubedAnnotationProcessor annotationProcessor = new CubedAnnotationProcessor();
    private final Map<String, ExecutorService> eventMap = new HashMap<>();

    private Dispatcher dispatcher;
    private Retrofit retrofit;


    public CubedPayAPI(String appID, String accessToken) {
        this(appID, accessToken, "https://api.cubedpay.com");
    }

    public CubedPayAPI(String appID, String accessToken, String apiUrl) {
        dispatcher = new Dispatcher();
        retrofit = new Retrofit.Builder()
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
                ).build();
    }

    public CubedPayShopAPI getShopAPI() {
        return retrofit.create(CubedPayShopAPI.class);
    }

    public CubedPayUserAPI getUserAPI() {
        return retrofit.create(CubedPayUserAPI.class);
    }

    public void registerListener(Object clazz) {
        annotationProcessor.processAnnotation(clazz);
    }

    public void startEvents(String shopID) {
        if (eventMap.containsKey(shopID)) return;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new CubedEventRunnable(this, shopID), 5, 20, TimeUnit.SECONDS);
        eventMap.put(shopID, executor);
    }

    public boolean emitEvent(CubedEvent event) {
        return annotationProcessor.emitEvent(event);
    }

    public void shutdown() throws InterruptedException {
        dispatcher.cancelAll();
        dispatcher.executorService().shutdown();
        dispatcher.executorService().awaitTermination(10, TimeUnit.SECONDS);
        for (ExecutorService executor : eventMap.values()) {
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
