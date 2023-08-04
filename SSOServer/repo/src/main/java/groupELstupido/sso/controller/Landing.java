package groupELstupido.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Landing {
    @RequestMapping("/")
    public String landing() {
        return "index";
    }

    @GetMapping ("/friends")
    public String friends() {
        return "friends";
    }
}
