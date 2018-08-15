package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;
import co.melondev.cubedpay.events.CubedEvent;
import co.melondev.cubedpay.events.transaction.TransactionCompletedEvent;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Event {

    private String id = "";
    private Type type;
    private Object obj = new Object();
    private Date created = new Date();
    private Date accepted = new Date();

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Object getObj() {
        return obj;
    }

    public Date getCreated() {
        return created;
    }

    public Date getAccepted() {
        return accepted;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", obj=" + obj +
                ", accepted=" + accepted +
                '}';
    }

    public enum Type {
        TRANSACTION_COMPLETED(TransactionCompletedEvent::new, "transaction_purchase");

        private Function<Event, CubedEvent> creator;
        private List<String> aliases = new ArrayList<>();

        Type(Function<Event, CubedEvent> creator, String... aliases) {
            this.creator = creator;
            this.aliases.addAll(Arrays.asList(aliases));
        }

        public Function<Event, CubedEvent> getCreator() {
            return creator;
        }

        public static Type findByTypeId(String typeID) {
            return Arrays.stream(values()).filter(type -> {
                if (type.name().equalsIgnoreCase(typeID) || type.name().replace('_', '-').equalsIgnoreCase(typeID)) {
                    return true;
                }

                return type.aliases.stream().anyMatch(alias ->
                        alias.equalsIgnoreCase(typeID) || alias.replace('_', '-').equalsIgnoreCase(typeID));
            }).findFirst().orElse(null);
        }
    }

    public static class Object {

        private static final Gson gson = new Gson();

        private String type;
        private JsonObject object;

        public String getType() {
            return type;
        }

        public <T> T getObject(Class<T> objectClazz) {
            return gson.fromJson(object, objectClazz);
        }

        @Override
        public String toString() {
            return "Event.Object{" +
                    "type='" + type + '\'' +
                    ", object=" + object +
                    '}';
        }
    }
}
