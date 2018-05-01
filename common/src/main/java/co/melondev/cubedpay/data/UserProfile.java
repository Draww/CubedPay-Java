package co.melondev.cubedpay.data;

import java.util.HashMap;
import java.util.Map;

public class UserProfile {

    private String id = "";
    private Game game;
    private String external_id = "";
    private Map<String, Object> data = new HashMap<>();

    public String getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public String getExternalId() {
        return external_id;
    }

    public Map<String, Object> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id='" + id + '\'' +
                ", game=" + game +
                ", external_id='" + external_id + '\'' +
                ", data=" + data +
                '}';
    }
}
