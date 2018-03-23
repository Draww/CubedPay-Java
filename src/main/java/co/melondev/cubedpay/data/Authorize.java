package co.melondev.cubedpay.data;

public class Authorize {

    private String id = "";
    private String redirect_to = "";
    private boolean is_authorized = false;
    private String authorized_by = "";

    public String getId() {
        return id;
    }

    public String getRedirectTo() {
        return redirect_to;
    }

    public boolean isAuthorized() {
        return is_authorized;
    }

    public String getAuthorizedBy() {
        return authorized_by;
    }
}
