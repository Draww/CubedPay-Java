package co.melondev.cubedpay;

import co.melondev.cubedpay.api.objects.BaseReturnObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

public class JacksonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Readers
    private final ObjectReader baseReturnReader = mapper.readerFor(BaseReturnObject.class);

    /**
     * Gets a base return object from a json string.
     *
     * @param value the value
     * @return the base return object.
     */
    public BaseReturnObject getBaseReturn(String value) {
        try {
            return baseReturnReader.readValue(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BaseReturnObject();
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
