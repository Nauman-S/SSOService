package groupELstupido.sso.controller;

import groupELstupido.sso.domain.model.UserDisplay;
import groupELstupido.sso.request.AuthenticateUserRequest;
import groupELstupido.sso.request.RegisterUserRequest;
import groupELstupido.sso.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
//            session.setAttribute("userLogin", true);
//            session.setAttribute("user", user);
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
    public ModelAndView handleSignUpEvent (@ModelAttribute RegisterUserRequest request) {
        System.out.println("Sign up POST URI Triggered");
        ModelAndView mv = new ModelAndView();
        if (userService.createUser(request) != -1) {
            UserDisplay userDisplay= new UserDisplay(request.getUsername(), request.getEmail());
            mv.addObject("userDisplay", userDisplay);
            mv.setViewName("profile");
        } else {
            mv.setViewName("signup");
        }

        return mv;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value={NullPointerException.class})
    public String unknownExceptionHandler(Model m) {
        m.addAttribute("msg", "NullPointer Exception In Accounts");
        return "unknownException";
    }

}
