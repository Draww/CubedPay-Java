package co.melondev.cubedpay.data;

import java.util.Date;
import java.util.List;

/**
 * @author theminecoder
 */
public class User {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Date memberSince;
    private List<UserProfile> profiles;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public List<UserProfile> getProfiles() {
        return profiles;
    }
}
