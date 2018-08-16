package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

import java.util.Arrays;
import java.util.List;

public class SupportTicket {

    public enum Status {
        OPEN,
        PENDING,
        HOLD,
        PROGRESS,
        CLOSED;

        public static Status findById(String id) {
            return Arrays.stream(values()).filter(status -> status.name().equalsIgnoreCase(id))
                    .findFirst().orElse(null);
        }
    }

    public class SupportUser {
        private int id;
        private String name;
        private String email;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public class Reply {
        private String id;
        private SupportUser from;
        private String message;
        private Date created;

        public String getId() {
            return id;
        }

        public SupportUser getFrom() {
            return from;
        }

        public String getMessage() {
            return message;
        }

        public Date getCreated() {
            return created;
        }
    }

    private String id;
    private SupportUser from;
    private Status status;
    private PublicUser assigned;
    private String subject;
    private List<Reply> conversation;
    private PublicShop shop;

    public String getId() {
        return id;
    }

    public SupportUser getFrom() {
        return from;
    }

    public Status getStatus() {
        return status;
    }

    public PublicUser getAssigned() {
        return assigned;
    }

    public String getSubject() {
        return subject;
    }

    public List<Reply> getConversation() {
        return conversation;
    }

    public PublicShop getShop() {
        return shop;
    }
}
