package co.melondev.cubedpay.util;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * @author theminecoder
 */
public class APISuccessTransformerConverter<T> implements Converter<ResponseBody, T> {

    private Converter<ResponseBody, T> delegateConverter;

    public APISuccessTransformerConverter(Converter<ResponseBody, T> delegateConverter) {
        this.delegateConverter = delegateConverter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        Jac
        ResponseBody.create(value.contentType(), value.string());
        return delegateConverter.convert(value);
    }
}
