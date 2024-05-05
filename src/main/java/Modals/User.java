package Modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class User {
   @Id
   private int userId;
    private String userName;
    @Column(name = "Pass") private String password;
    private String privilege;
    private String email;
    private String profile;


    public User(int userId, String userName, String password, String privilege, String email,String profile) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.privilege = privilege;
        this.email = email;
        this.profile = profile;
    }

    public User() {

    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Optional toString method for debugging purposes
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", privilege='" + privilege + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
