package co.melondev.cubedpay;

import co.melondev.cubedpay.api.objects.BaseBadRequest;
import co.melondev.cubedpay.api.objects.BaseReturn;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

public class JacksonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Readers
    private final ObjectReader baseReturn = mapper.readerFor(BaseReturn.class);
    private final ObjectReader badRequest = mapper.readerFor(BaseBadRequest.class);

    /**
     * Gets a base return object from a json string.
     *
     * @param value the value
     * @return the base return object.
     */
    public BaseReturn getReturn(String value) {
        try {
            return baseReturn.readValue(value);
        } catch (IOException e) {
            return new BaseReturn();
        }
    }


    /**
     * Gets a bad request object from a json string.
     *
     * @param value the value
     * @return the base return object.
     */
    public BaseBadRequest getBadRequest(String value) {
        try {
            return badRequest.readValue(value);
        } catch (IOException e) {
            return new BaseBadRequest();
        }
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
