package co.melondev.cubedpay.data;

import co.melondev.cubedpay.data.common.Date;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", memberSince=" + memberSince +
                ", profiles=" + profiles +
                '}';
    }
}
