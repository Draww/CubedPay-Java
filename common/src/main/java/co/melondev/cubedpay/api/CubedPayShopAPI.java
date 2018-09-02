package co.melondev.cubedpay.api;

import co.melondev.cubedpay.data.*;
import co.melondev.cubedpay.data.common.Cursor;
import retrofit2.http.*;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface CubedPayShopAPI {

    @GET("/shop")
    CompletableFuture<Cursor<Shop>> getShops(@Query("page") int page, @Query("perpage") int perPage);

    @GET("/shop/{sid}")
    CompletableFuture<Shop> getShop(@Path("sid") String shopId);

    @POST("/shop/{sid}")
    CompletableFuture<Shop> updateShop(@Path("sid") String shopId, @Query("name") String name, @Query("sandbox") boolean sandbox);

    @POST("/shop/{sid}")
    CompletableFuture<Shop> updateShop(@Path("sid") String shopId, @Query("name") String name, @Query("sandbox") boolean sandbox, @Query("logo") File logo);

    @GET("/shop/{sid}/customers")
    CompletableFuture<PublicUser> getCustomers(@Path("sid") String shopId);

    //region Managers
    @POST("/shop/{sid}/manager")
    CompletableFuture<ShopManager> inviteShopManager(@Path("sid") String shopId, @Query("manager_id") String managerId, @Query("permissions") String permissions);

    @POST("/shop/{sid}/manager/{mid}")
    CompletableFuture<ShopManager> grantShopPermission(@Path("sid") String shopId, @Path("mid") String managerId, @Query("permission") String permission);

    @DELETE("/shop/{sid}/manager/{mid}")
    CompletableFuture<ShopManager> revokeShopPermission(@Path("sid") String shopId, @Path("mid") String managerId, @Query("permission") String permission);

    @PATCH("/shop/{sid}/manager/{mid}")
    CompletableFuture<ShopManager> updateAllPermissions(@Path("sid") String shopId, @Path("mid") String managerId, @Query("permissions") String permissions);
    //endregion

    //region Packages
    @GET("/shop/{sid}/package")
    CompletableFuture<Cursor<ShopPackage>> getPackages(@Path("sid") String shopId, @Query("page") int page, @Query("perpage") int perPage);

    @GET("/shop/{sid}/package/{pid}")
    CompletableFuture<ShopPackage> getPackage(@Path("sid") String shopId, @Path("pid") String packageId);

    @POST("/shop/{sid}/package")
    CompletableFuture<ShopPackage> createPackage(@Path("sid") String shopId, @Query("name") String name, @Query("description") String description, @Query("price") double price, @Query("public") boolean isPublic);

    @POST("/shop/{sid}/package")
    CompletableFuture<ShopPackage> createPackage(@Path("sid") String shopId, @Query("name") String name, @Query("description") String description, @Query("price") double price, @Query("public") boolean isPublic, @Query("icon") File icon);

    @PATCH("/shop/{sid}/package/{pid}")
    CompletableFuture<ShopPackage> updatePackage(@Path("sid") String shopId, @Path("pid") String packageId, @Query("name") String name, @Query("description") String description, @Query("price") double price, @Query("public") boolean isPublic);

    @PATCH("/shop/{sid}/package/{pid}")
    CompletableFuture<ShopPackage> updatePackage(@Path("sid") String shopId, @Path("pid") String packageId, @Query("name") String name, @Query("description") String description, @Query("price") double price, @Query("public") boolean isPublic, @Query("icon") File icon);

    @DELETE("/shop/{sid}/package/{pid}")
    CompletableFuture<DeleteConfirmation> deletePackage(@Path("sid") String shopId, @Path("pid") String packageId);
    //endregion

    //region Transactions
    @GET("/shop/{sid}/transaction")
    CompletableFuture<Cursor<Transaction>> getTransactions(@Path("sid") String shopId, @Query("page") int page, @Query("perpage") int perPage);

    @GET("/shop/{sid}/transaction/{tid}")
    CompletableFuture<Transaction> getTransaction(@Path("sid") String shopId, @Path("tid") String transactionId);

    default CompletableFuture<Transaction> createTransaction(String shopId, String customer, String profile, Item... item) {
        return createTransaction(shopId, customer, profile, new Items(item));
    }

    @POST("/shop/{sid}/transaction")
    CompletableFuture<Transaction> createTransaction(@Path("sid") String shopId, @Query("customer") String customer, @Query("profile") String profile, @Body Items items);

    @PUT("/shop/{sid}/transaction/{tid}/discount")
    CompletableFuture<Transaction> setTransactionDiscount(@Path("sid") String shopId, @Path("tid") String transactionId, @Query("discount") String discountCode);

    @GET("/shop/{sid}/transaction/{tid}/products")
    CompletableFuture<List<TransactionPackage>> getTransactionPackages(@Path("sid") String shopId, @Path("tid") String transactionId);

    @GET("/shop/{sid}/transaction/{tid}/payments")
    CompletableFuture<List<TransactionPayment>> getTransactionPayments(@Path("sid") String shopId, @Path("tid") String transactionId);
    //endregion

    //region Events
    @GET("/shop/{sid}/event")
    CompletableFuture<Cursor<Event>> getEvents(@Path("sid") String shopId);

    @POST("/shop/{sid}/event/{eid}/ack")
    CompletableFuture<EventAccept> acceptEvent(@Path("sid") String shopId, @Path("eid") String eventId);
    //endregion

    //region Page
    @GET("/shop/{sid}/page")
    CompletableFuture<Cursor<ShopPage>> getPages(@Path("sid") String shopId, @Query("page") int page, @Query("perpage") int perPage);

    @GET("/shop/{sid}/page/{pid}")
    CompletableFuture<ShopPage> getPage(@Path("sid") String shopId, @Path("pid") String pageId);

    @POST("/shop/{sid}/page")
    CompletableFuture<ShopPage> createPage(@Path("sid") String shopId, @Query("name") String name, @Query("description") String description, @Query("public") boolean isPublic, @Query("type") ShopPage.Type type, @Query("display") ShopPage.Display display, @Query("order") int order);

    @PATCH("/shop/{sid}/page/{pid}")
    CompletableFuture<ShopPage> updatePage(@Path("sid") String shopId, @Path("pid") String pageId, @Query("name") String name, @Query("description") String description, @Query("public") boolean isPublic, @Query("type") ShopPage.Type type, @Query("display") ShopPage.Display display, @Query("order") int order);

    @DELETE("/shop/{sid}/page/{pid}")
    CompletableFuture<DeleteConfirmation> deletePage(@Path("sid") String shopId, @Path("pid") String pageId);

    //region Basic Page Packages
    @GET("/shop/{sid}/page/{pid}/package")
    CompletableFuture<Cursor<ShopPagePackage>> getBasicPagePackages(@Path("sid") String shopId, @Path("pid") String pageId, @Query("page") int page, @Query("perpage") int perPage);

    @POST("/shop/{sid}/page/{pid}/package")
    CompletableFuture<ShopPagePackage> addBasicPagePackage(@Path("sid") String shopId, @Path("pid") String pageId, @Query("package") String packageId, @Query("order") int order);

    @PATCH("/shop/{sid}/page/{pid}/package/{ppid}")
    CompletableFuture<ShopPagePackage> updateBasicPagePackage(@Path("sid") String shopId, @Path("pid") String pageId, @Path("ppid") String pagePackageId, @Query("order") int order);

    @DELETE("/shop/{sid}/page/{pid}/package/{ppid}")
    CompletableFuture<DeleteConfirmation> deleteBasicPagePackage(@Path("sid") String shopId, @Path("pid") String pageId, @Path("ppid") String pagePackageId);
    //endregion

    //endregion

    //region Sidebar
    @GET("/shop/{sid}/sidebar")
    CompletableFuture<Cursor<ShopSidebarModule>> getSidebarModules(@Path("sid") String shopId, @Query("page") int page, @Query("perpage") int perPage);

    @GET("/shop/{sid}/sidebar/{mid}")
    CompletableFuture<ShopSidebarModule> getSidebarModule(@Path("sid") String shopId, @Path("mid") String moduleId);

    @POST("/shop/{sid}/sidebar")
    CompletableFuture<ShopSidebarModule> addSidebarModule(@Path("sid") String shopId, @Query("type") ShopSidebarModule.Type type, @Query("side") ShopSidebarModule.Side side, @Query("settings") Map<String, Object> settings, @Query("public") boolean isPublic, @Query("order") int order);

    @POST("/shop/{sid}/sidebar/{mid}")
    CompletableFuture<ShopSidebarModule> updateSidebarModule(@Path("sid") String shopId, @Path("mid") String moduleId, @Query("type") ShopSidebarModule.Type type, @Query("side") ShopSidebarModule.Side side, @Query("settings") Map<String, Object> settings, @Query("public") boolean isPublic, @Query("order") int order);

    @DELETE("/shop/{sid}/sidebar/{mid}")
    CompletableFuture<DeleteConfirmation> deleteSidebarModule(@Path("sid") String shopId, @Path("mid") String moduleId);
    //endregion

    //region Theme
    @GET("/shop/{sid}/theme")
    CompletableFuture<Cursor<ShopTheme>> getShopThemes(@Path("sid") String shopId, @Query("page") int page, @Query("perpage") int perPage);

    @PUT("/shop/{sid}/theme")
    CompletableFuture<ShopTheme> setShopTheme(@Path("sid") String shopId, @Query("theme") String themeId);
    //endregion

    //region Sales
    @GET("/shop/{sid}/sale")
    CompletableFuture<Cursor<ShopSale>> getSales(@Path("sid") String shopId, @Query("page") int page, @Query("perpage") int perPage);

    @GET("/shop/{sid}/sale/{sale}")
    CompletableFuture<ShopSale> getSale(@Path("sid") String shopId, @Path("sale") String saleId);

    @POST("/shop/{sid}/sale")
    CompletableFuture<ShopSale> createSale(@Path("sid") String shopId, @Query("name") String name, @Query("amount") double amount, @Query("percent") boolean percent, @Query("active") boolean active, @Query("visible") boolean visible, @Query("banner") String banner, @Query("starts") long starts, @Query("ends") long ends);

    @PATCH("/shop/{sid}/sale/{sale}")
    CompletableFuture<ShopSale> updateSale(@Path("sid") String shopId, @Path("sale") String saleId, @Query("name") String name, @Query("amount") double amount, @Query("percent") boolean percent, @Query("active") boolean active, @Query("visible") boolean visible, @Query("banner") String banner, @Query("starts") long starts, @Query("ends") long ends);

    @DELETE("/shop/{sid}/sale/{sale}")
    CompletableFuture<DeleteConfirmation> deleteSale(@Path("sid") String shopId, @Path("sale") String saleId);

    @GET("/shop/{sid}/sale/{sale}/packageRef")
    CompletableFuture<Cursor<ShopSalePackageRef>> getSalePackageRefs(@Path("sid") String shopId, @Path("sale") String saleId, @Query("page") int page, @Query("perpage") int perPage);

    @POST("/shop/{sid}/sale/{sale}/packageRef")
    CompletableFuture<ShopSalePackageRef> addPackageRefToSale(@Path("sid") String shopId, @Path("sale") String saleId, @Query("type") ShopPackageRef.Type type, @Query("data") String data);

    @DELETE("/shop/{sid}/sale/{sale}/packageRef/{prid}")
    CompletableFuture<DeleteConfirmation> removePackageRefFromSale(@Path("sid") String shopId, @Path("sale") String saleId, @Path("prid") String packageRefId);
    //endregion

    //region Discounts
    @GET("/shop/{sid}/discount")
    CompletableFuture<Cursor<ShopDiscount>> getDiscounts(@Path("sid") String shopId, @Query("page") int page, @Query("perpage") int perPage);

    @GET("/shop/{sid}/discount/{discount}")
    CompletableFuture<ShopDiscount> getDiscount(@Path("sid") String shopId, @Path("discount") String saleId);

    @POST("/shop/{sid}/discount")
    CompletableFuture<ShopDiscount> createDiscount(@Path("sid") String shopId, @Query("name") String name, @Query("amount") double amount, @Query("percent") boolean percent, @Query("active") boolean active, @Query("starts") long starts, @Query("ends") long ends, @Query("code") String code, @Query("maxUses") int masUses, @Query("useWithSale") boolean useWithSale);

    @PATCH("/shop/{sid}/discount/{discount}")
    CompletableFuture<ShopDiscount> updateDiscount(@Path("sid") String shopId, @Path("discount") String saleId, @Query("name") String name, @Query("amount") double amount, @Query("percent") boolean percent, @Query("active") boolean active, @Query("starts") long starts, @Query("ends") long ends, @Query("code") String code, @Query("maxUses") int masUses, @Query("useWithSale") boolean useWithSale);

    @DELETE("/shop/{sid}/discount/{discount}")
    CompletableFuture<DeleteConfirmation> deleteDiscount(@Path("sid") String shopId, @Path("discount") String saleId);

    @GET("/shop/{sid}/discount/{discount}/packageRef")
    CompletableFuture<Cursor<ShopDiscountPackageRef>> getDiscountPackageRefs(@Path("sid") String shopId, @Path("discount") String discountId, @Query("page") int page, @Query("perpage") int perPage);

    @POST("/shop/{sid}/discount/{discount}/packageRef")
    CompletableFuture<ShopDiscountPackageRef> addPackageRefToDiscount(@Path("sid") String shopId, @Path("discount") String discountId, @Query("type") ShopPackageRef.Type type, @Query("data") String data);

    @DELETE("/shop/{sid}/discount/{discount}/packageRef/{prid}")
    CompletableFuture<DeleteConfirmation> removePackageRefFromDiscount(@Path("sid") String shopId, @Path("discount") String discountId, @Path("prid") String packageRefId);
    //endregion

    //region Support
    @GET("/shop/{sid}/ticket")
    CompletableFuture<Cursor<SupportTicket>> getSupportTickets(@Path("sid") String shopId, @Query("page") int page, @Query("perpage") int perpage);

    @POST("/shop/{sid}/ticket/open")
    CompletableFuture<SupportTicket> createSupportTicket(@Path("sid") String shopId, @Query("from_name") String user_name, @Query("from_email") String user_email, @Query("subject") String subject, @Query("body") String body);

    @GET("/shop/{sid}/ticket/{tid}")
    CompletableFuture<SupportTicket> getSupportTicket(@Path("sid") String shopId, @Path("tid") String ticketId);

    @PATCH("/shop/{sid}/ticket/{tid}")
    CompletableFuture<SupportTicket> updateSupportTicket(@Path("sid") String shopId, @Path("tid") String ticketId, @Query("status") SupportTicket.Status status);

    @POST("/shop/{sid}/ticket/{tid}/assign")
    CompletableFuture<SupportTicket> assignManagerToSupportTicket(@Path("sid") String shopId, @Path("tid") String ticketId, @Query("assign_to") String user);

    //TODO See if this is actually needed
    @POST("/shop/{sid}/ticket/{tid}/read")
    CompletableFuture<SupportTicket> updateSupportTicketReadState(@Path("sid") String shopId, @Path("tid") String ticketId);

    @POST("/shop/{sid}/ticket/{tid}/reply")
    CompletableFuture<SupportTicket> replyToSupportTicket(@Path("sid") String shopId, @Path("tid") String ticketId, @Query("message") String message);
    //endregion

}
