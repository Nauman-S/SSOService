package groupELstupido.sso.service;

import groupELstupido.sso.dao.UserDao;
import groupELstupido.sso.domain.model.UserDisplay;
import groupELstupido.sso.request.AuthenticateUserRequest;
import groupELstupido.sso.request.RegisterUserRequest;
import groupELstupido.sso.util.EmailUtil;
import groupELstupido.sso.util.PasswordUtil;
import groupELstupido.sso.util.UsernameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private UsernameUtil usernameUtil;

    @Autowired
    private PasswordUtil passwordUtil;

    public UserDisplay createUser (RegisterUserRequest request) {
        String email = emailUtil.canonicalizeEmail(request.getEmail());
        if (!emailUtil.validateEmailFormat(email) ){
            return null;
        } else if (!usernameUtil.validateUsername(request.getUsername())) {
            return null;
        } else if (!passwordUtil.validatePassword(request.getPassword())) {
            return null;
        }
        else if (userDao.usernameExists(request.getUsername()) || userDao.emailExists(request.getEmail()) ) {
            return null;
        }

     return userDao.createUser(request.getUsername(), email, request.getPassword());
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
