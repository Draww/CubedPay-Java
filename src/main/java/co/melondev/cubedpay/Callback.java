package co.melondev.cubedpay;

/**
 * A generic interface for callbacks.
 *
 * @param <T> the type of object you would like returned.
 */
public interface Callback<T> {

    /**
     * The default method for the callback.
     *
     * @param response the response
     */
    void callback(T response);
}
