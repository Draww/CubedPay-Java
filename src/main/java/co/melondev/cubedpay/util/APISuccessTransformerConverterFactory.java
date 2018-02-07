package co.melondev.cubedpay.util;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author theminecoder
 */
public class APISuccessTransformerConverterFactory extends Factory {

    private Factory superConverter;

    public APISuccessTransformerConverterFactory(Factory superConverter) {
        this.superConverter = superConverter;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new APISuccessTransformerConverter(superConverter.responseBodyConverter(type, annotations, retrofit));
    }
}
