package co.melondev.cubedpay.data;

import java.util.List;

/**
 * @author theminecoder
 */
public class ShopManager {

    private String id;
    private PublicUser user;
    private boolean isOwner;
    private boolean grantAll;
    private List<String> permissions;

    public String getId() {
        return id;
    }

    public PublicUser getUser() {
        return user;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public boolean isGrantAll() {
        return grantAll;
    }

    public List<String> getPermissions() {
        return permissions;
    }
}
