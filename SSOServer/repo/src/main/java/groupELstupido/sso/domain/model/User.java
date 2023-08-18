package groupELstupido.sso.domain.model;

public class User {
    private int identifier;
    private String username;
    private String email;

    private String password;

    private UserImage userImage;

    public User(String username, String email, String password, int identifier) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.identifier = identifier;
    }

    public void setUserImage(UserImage userImage) {
        this.userImage = userImage;
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getIdentifier () { return identifier; }

    public UserImage getUserImage() {
        return userImage;
    }

    public String toString() {
        return String.format("User Object - {username = %s, email = %s, identifier = %d}", username, email, identifier);
    }
}
