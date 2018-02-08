package co.melondev.cubedpay.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author theminecoder
 */
public class User {

    private long id = 0;
    private String username = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private Date memberSince = new Date();
    private List<UserProfile> profiles = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public List<UserProfile> getProfiles() {
        return profiles;
    }
}
