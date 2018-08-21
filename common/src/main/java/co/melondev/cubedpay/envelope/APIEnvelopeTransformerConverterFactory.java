package co.melondev.cubedpay.envelope;

import com.google.gson.Gson;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URLConnection;
import java.util.Base64;

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
        if (type instanceof Class && ((Class) type).isEnum()) {
            return (Converter<Object, String>) value -> ((Enum) value).name();
        }
        if (type instanceof Class && ((Class) type) == File.class) {
            return (Converter<Object, String>) value -> {
                File file = (File) value;
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

                long length = file.length();
                if (length > Integer.MAX_VALUE) {
                    throw new IOException("File is too large to be sent");
                }
                byte[] bytes = new byte[(int) length];
                int offset = 0;
                int numRead = 0;
                while (offset < bytes.length
                        && (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
                    offset += numRead;
                }
                if (offset < bytes.length) {
                    throw new IOException("Could not completely read file " + file.getName());
                }
                in.close();

                //I know what your thinking, but this is how I got things to work
                in = new BufferedInputStream(new FileInputStream(file));
                String mimeType = URLConnection.guessContentTypeFromStream(in);
                in.close();

                if (!mimeType.toLowerCase().startsWith("image/")) {
                    throw new IOException("Only can upload image files");
                }

                return "data:" + mimeType + ";base64," + Base64.getEncoder().encodeToString(bytes);
            };
        }
        return gson::toJson;
    }
}
