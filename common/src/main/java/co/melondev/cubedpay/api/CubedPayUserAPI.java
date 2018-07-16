package co.melondev.cubedpay.api;

import co.melondev.cubedpay.data.User;
import retrofit2.http.GET;

import java.util.concurrent.CompletableFuture;

/**
 * @author theminecoder
 */
public interface CubedPayUserAPI {

    @GET("/user")
    CompletableFuture<User> getCurrentUser();

}
