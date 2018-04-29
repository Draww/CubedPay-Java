package co.melondev.cubedpay.data;

import java.util.HashMap;
import java.util.Map;

public class UserProfile {

    private String id = "";
    private String game = "";
    private String external_id = "";
    private Map<String, Object> data = new HashMap<>();

    public String getId() {
        return id;
    }

    public String getGame() {
        return game;
    }

    public String getExternalId() {
        return external_id;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
