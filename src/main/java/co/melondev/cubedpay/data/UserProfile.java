package co.melondev.cubedpay.data;

import java.util.HashMap;
import java.util.Map;

public class UserProfile {

    private String id = "";
    private String game = "";
    private String externalId = "";
    private Map<String, Object> data = new HashMap<>();

    public String getId() {
        return id;
    }

    public String getGame() {
        return game;
    }

    public String getExternalId() {
        return externalId;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
