package groupELstupido.sso.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accounts")
public class Accounts {
    @GetMapping("/login")
    public String login() {
        System.out.println("Login GET URI Triggered");
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView handleLoginEvent(@RequestParam("identifier") String identifier, @RequestParam("password") String password) {
        System.out.println("Login POST URI Triggered");
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", identifier);
        mv.setViewName("home");
        return mv;
    }



    @GetMapping("/signup")
    public String register() {
        System.out.println("Sign up GET URI Triggered");
        return "signup";
    }

    @PostMapping("/signup")
    public ModelAndView handleSignUpEvent (@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("username") String username) {
        System.out.println("Sign up POST URI Triggered");
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", username);
        mv.setViewName("home");
        return mv;
    }
}
