package co.melondev.cubedpay.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlRequests {

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Get response from a url.
     *
     * @param url the url
     * @return the response
     */
    public UrlResponse get(String url) {
        return request(url, null, ResponseType.GET);
    }

    /**
     * Sends a put response to a url with the certain data.
     *
     * @param url  the url
     * @param data the data
     * @return the response
     */
    public UrlResponse put(String url, Object data) {
        return request(url, data, ResponseType.PUT);
    }

    /**
     * Sends a post response to a url with the certain data.
     *
     * @param url  the url
     * @param data the data
     * @return the response
     */
    public UrlResponse post(String url, Object data) {
        return request(url, data, ResponseType.POST);
    }

    /**
     * Request a response from a url with a certain type.
     *
     * @param url  the url
     * @param data the data
     * @return the response
     */
    private UrlResponse request(String url, Object data, ResponseType type) {
        UrlResponse response = new UrlResponse();
        try {
            URL urlObject = new URL(url);
            // Create connection
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            // Set user agent to chrome just so nothing funky happens.
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
            connection.setRequestMethod(type.name().toLowerCase());
            // Set properties to be json
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            // Write and send if not a get
            if (type != ResponseType.GET && data != null) {
                connection.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
                dataOutputStream.write(mapper.writeValueAsBytes(data));
                dataOutputStream.flush();
                dataOutputStream.close();
            }
            // Output all the required info.
            try {
                response.setResponseCode(connection.getResponseCode());
                response.setInputStream(connection.getInputStream());
            } catch (FileNotFoundException e) {
                // We probably 404ed because java is horrible and throws this exception on a 404.
                response.setResponseCode(404);
                response.setInputStream(connection.getErrorStream());
                response.setExceptionMessage(getStackTrace(e));
            }
            connection.disconnect();
            return response;
        } catch (IOException e) {
            // A not so happy exception occurred here. Could be a load of things because java loves exceptions.
            response.setResponseCode(404);
            response.setExceptionMessage(getStackTrace(e));
            return response;
        }
    }

    /**
     * Will convert a throwable/exception into a string format.
     *
     * @param throwable  the throwable/exception
     * @return a printable stack trace
     */
    private String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    private enum ResponseType {
        /**
         * Get response type.
         */
        GET,
        /**
         * Put response type.
         */
        PUT,
        /**
         * Post response type.
         */
        POST
    }
}
