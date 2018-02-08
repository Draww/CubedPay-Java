package co.melondev.cubedpay.envelope;

import co.melondev.cubedpay.CubedPayException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;

/**
 * @author theminecoder
 */
public class ADIEnvelopeTransformerConverter<T> implements Converter<ResponseBody, T> {

    private static Gson gson = new Gson();
    private Converter<ResponseBody, T> delegateConverter;

    public ADIEnvelopeTransformerConverter(Converter<ResponseBody, T> delegateConverter) {
        this.delegateConverter = delegateConverter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        JsonObject fullResponse = gson.fromJson(value.charStream(), JsonElement.class).getAsJsonObject();
        JsonObject returnResponse = fullResponse.getAsJsonObject("return");

        if (!fullResponse.getAsJsonPrimitive("success").getAsBoolean()) {
            throw new CubedPayException(returnResponse.getAsJsonPrimitive("code").getAsInt(),
                    returnResponse.getAsJsonPrimitive("message").getAsString());
        }

        return delegateConverter.convert(ResponseBody.create(value.contentType(), returnResponse.toString()));
    }
}
