package groupELstupido.sso.domain.model;

public class UserDisplay {
    private String username;
    private String email;

    public UserDisplay(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
