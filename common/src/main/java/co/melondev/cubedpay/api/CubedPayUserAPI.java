package co.melondev.cubedpay.api;

import co.melondev.cubedpay.data.*;
import co.melondev.cubedpay.data.common.Cursor;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CubedPayUserAPI {

    @GET("/user")
    CompletableFuture<User> getCurrentUser();

    @GET("/user/profile")
    CompletableFuture<List<UserProfile>> getProfiles();

    //region Support
    @GET("/user/ticket")
    CompletableFuture<List<SupportTicket>> getSupportTickets();

    @POST("/user/ticket/{tid}/close")
    CompletableFuture<SupportTicket> closeSupportTicket(@Path("tid") String ticketId);

    @POST("/user/ticket/{tid}/reply")
    CompletableFuture<SupportTicket> replyToSupportTicket(@Path("tid") String ticketId, @Query("message") String message);
    //endregion

    //region Transactions
    @GET("/user/transaction")
    CompletableFuture<Cursor<Transaction>> getTransactions(@Query("page") int page, @Query("perpage") int perpage);

    @GET("/user/transaction/{tid}")
    CompletableFuture<Transaction> getTransaction(@Path("tid") String transactionId);

    @GET("/user/transaction/{tid}/payments")
    CompletableFuture<List<TransactionPayment>> getTransactionPayments(@Path("tid") String transactionId);

    @GET("/user/transaction/{tid}/products")
    CompletableFuture<List<TransactionPackage>> getTransactionPackages(@Path("tid") String transactionId);
    //endregion

}
