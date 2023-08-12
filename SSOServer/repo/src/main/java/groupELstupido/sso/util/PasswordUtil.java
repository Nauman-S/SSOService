package groupELstupido.sso.util;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
    public boolean validatePassword (String password) {
        return password.length() >= 8;
    }
}
