package groupELstupido.sso.service;

import groupELstupido.sso.dao.UserDao;
import groupELstupido.sso.domain.model.User;
import groupELstupido.sso.domain.model.UserDisplay;
import groupELstupido.sso.request.AuthenticateUserRequest;
import groupELstupido.sso.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private EmailUtil emailUtil;

    public int createUser (User user) {
        if (userDao.usernameExists(user.getUsername()) || userDao.emailExists(user.getEmail())) {
            return -1;
        }
     return userDao.createUser(user);
    }

    public UserDisplay authenticateUser (AuthenticateUserRequest request) {

        UserDisplay user;
        if ((user = getUserByEmail(request)) != null) {
            return user;
        } else if ((user = getUserByUsername(request)) != null) {
            return user;
        }
        return null;
    }

    private UserDisplay getUserByEmail (AuthenticateUserRequest request) {
        String canonicalizeEmail = emailUtil.canonicalizeEmail(request.getIdentifier());
        if (emailUtil.validateEmailFormat(canonicalizeEmail)) {
            return userDao.getUserByEmailAndPassword(canonicalizeEmail, request.getPassword());
        }
        return null;
    }

    private UserDisplay getUserByUsername (AuthenticateUserRequest request) {
        return userDao.getUserByUsernameAndPassword(request.getIdentifier(), request.getPassword());
    }

}
