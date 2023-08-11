package groupELstupido.sso.controller;

import groupELstupido.sso.domain.model.User;
import groupELstupido.sso.domain.model.UserDisplay;
import groupELstupido.sso.request.AuthenticateUserRequest;
import groupELstupido.sso.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accounts")
public class Accounts {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        System.out.println("Login GET URI Triggered");
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView handleLoginEvent(@ModelAttribute AuthenticateUserRequest authenticateUserRequest, HttpSession session) {
        System.out.println("Login POST URI Triggered");

        ModelAndView mv = new ModelAndView();
        UserDisplay user ;
        if ((user = userService.authenticateUser(authenticateUserRequest) )!= null ) {
            session.setAttribute("userLogin", true);
            session.setAttribute("user", user);
            mv.addObject("userDisplay", user);
            mv.setViewName("profile");
        } else {
            mv.setViewName("redirect:/accounts/login");
        }
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
        User user = new User(username, email, password);
        ModelAndView mv = new ModelAndView();
        if (userService.createUser(user) != -1) {
            mv.addObject("username", username);
            mv.setViewName("home");
        } else {
            mv.setViewName("signup");
        }

        return mv;
    }
}
