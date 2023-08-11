package groupELstupido.sso.util;

import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    private String validEmailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public String canonicalizeEmail(String email) {
        if (email == null) {
            return "";
        }
        return email.toLowerCase();
    }

    public boolean validateEmailFormat(String email) {
        return email.matches(validEmailRegex);
    }


}
