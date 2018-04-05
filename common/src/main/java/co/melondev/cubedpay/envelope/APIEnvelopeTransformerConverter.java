package co.melondev.cubedpay.envelope;

import co.melondev.cubedpay.CubedPayException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;

public class APIEnvelopeTransformerConverter<T> implements Converter<ResponseBody, T> {

    private static Gson gson = new Gson();
    private Converter<ResponseBody, T> delegateConverter;

    public APIEnvelopeTransformerConverter(Converter<ResponseBody, T> delegateConverter) {
        this.delegateConverter = delegateConverter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        JsonObject fullResponse;
        try {
            fullResponse = gson.fromJson(value.charStream(), JsonElement.class).getAsJsonObject();
        } catch (JsonParseException e) {
            throw new CubedPayException(500, "Server sent back invalid json:\n" + value.string());
        }
        JsonObject returnResponse = fullResponse.getAsJsonObject("return");

        if (!fullResponse.getAsJsonPrimitive("success").getAsBoolean()) {
            throw new CubedPayException(returnResponse.getAsJsonPrimitive("code").getAsInt(),
                    returnResponse.getAsJsonPrimitive("message").getAsString());
        }

        return delegateConverter.convert(ResponseBody.create(value.contentType(), returnResponse.toString()));
    }
}
