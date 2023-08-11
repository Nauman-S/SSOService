package groupELstupido.sso.util;

import org.springframework.stereotype.Component;

@Component
public class UsernameUtil {
    private String validUsernameRegex = "(.*?)";
    public boolean validateUsername (String username) {
        return username.matches(validUsernameRegex);
    }
}
