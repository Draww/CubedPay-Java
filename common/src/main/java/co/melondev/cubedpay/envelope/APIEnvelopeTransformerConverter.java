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

    APIEnvelopeTransformerConverter(Converter<ResponseBody, T> delegateConverter) {
        this.delegateConverter = delegateConverter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        JsonObject fullResponse;
        String valueString = value.string();
//        System.out.println(valueString);
        try {
            fullResponse = gson.fromJson(valueString, JsonElement.class).getAsJsonObject();
        } catch (JsonParseException e) {
            throw new CubedPayException(500, "Server sent back invalid json:\n" + valueString);
        }

//        if (fullResponse.has("debug") && fullResponse.get("debug").isJsonObject()) {
//            System.out.println("Cubed DEBUG: " + fullResponse.get("debug").toString());
//        }

        if (!fullResponse.getAsJsonPrimitive("success").getAsBoolean()) {
            JsonObject errorObject = fullResponse.getAsJsonObject("return");
            throw new CubedPayException(errorObject.getAsJsonPrimitive("code").getAsInt(),
                    errorObject.getAsJsonPrimitive("message").getAsString());
        }

        return delegateConverter.convert(ResponseBody.create(value.contentType(), fullResponse.get("return").toString()));
    }
}
