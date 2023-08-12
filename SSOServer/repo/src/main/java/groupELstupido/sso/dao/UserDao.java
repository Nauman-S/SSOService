package groupELstupido.sso.dao;

import groupELstupido.sso.domain.model.User;
import groupELstupido.sso.domain.model.UserDisplay;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    List<User> userList = new ArrayList<>();
    public int createUser(String username, String email, String password) {
        userList.add(new User(username, email, password));
        return userList.size();
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
                    return new UserDisplay(userFromList.getUsername(), userFromList.getEmail());
                }
                return null;
            }
        }
        return null;
    }

    public UserDisplay getUserByUsernameAndPassword (String username, String password) {
        for (User userFromList: userList) {
            if (username.equals(userFromList.getUsername())) {
                if (password.equals(userFromList.getPassword())) {
                    return new UserDisplay(userFromList.getUsername(), userFromList.getEmail());
                }
                return null;
            }
        }
        return null;
    }
}
