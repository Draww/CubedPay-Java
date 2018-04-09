package co.melondev.cubedpay.envelope;

import com.google.gson.Gson;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class APIEnvelopeTransformerConverterFactory extends Factory {

    private static final Gson gson = new Gson();
    private Factory delegateConverterFactory;

    public APIEnvelopeTransformerConverterFactory(Factory delegateConverterFactory) {
        this.delegateConverterFactory = delegateConverterFactory;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new APIEnvelopeTransformerConverter(delegateConverterFactory.responseBodyConverter(type, annotations, retrofit));
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return delegateConverterFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }

    @Override
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type instanceof Class && (((Class) type).isPrimitive() || ((Class) type) == String.class)) {
            return null;
        }
        return gson::toJson;
    }
}
