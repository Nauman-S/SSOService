package groupELstupido.sso.dao;

import groupELstupido.sso.domain.model.User;
import groupELstupido.sso.domain.model.UserDisplay;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    List<User> userList = new ArrayList<>();
    public UserDisplay createUser(String username, String email, String password) {
        int identifier = userList.size();
        userList.add(new User(username, email, password, identifier));
        return new UserDisplay(username, email, identifier);
    }

    public boolean usernameExists (String username) {
        for (User userFromList: userList) {
            if (userFromList.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean emailExists (String email) {
        for (User userFromList: userList) {
            if (userFromList.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public UserDisplay getUserByEmailAndPassword(String email, String password) {
        for (User userFromList: userList) {
            if (email.equals(userFromList.getEmail())) {
                if (password.equals(userFromList.getPassword())) {
                    return new UserDisplay(userFromList.getUsername(),userFromList.getEmail(), userFromList.getIdentifier());
                }
                return null;
            }
        }
        return null;
    }

    public UserDisplay getUserByUsernameAndPassword (String username, String password) {
        UserDisplay userDisplay  = getUserByUsername(username);
        if (userDisplay != null) {
            User user = userList.get(userDisplay.getUserIdentifier());
            if (password.equals(user.getPassword())) {
                return userDisplay;
            }
        }
        return null;
    }

    public UserDisplay getUserByUsername(String username) {
        for (User userFromList: userList) {
            if (username.equals(userFromList.getUsername())) {
                return new UserDisplay(userFromList.getUsername(), userFromList.getEmail(), userFromList.getIdentifier());
            }
        }
        return null;
    }
}
