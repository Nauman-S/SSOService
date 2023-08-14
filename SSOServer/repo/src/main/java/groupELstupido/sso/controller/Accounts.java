package groupELstupido.sso.controller;

import groupELstupido.sso.domain.model.UserDisplay;
import groupELstupido.sso.request.AuthenticateUserRequest;
import groupELstupido.sso.request.RegisterUserRequest;
import groupELstupido.sso.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ModelAndView login(HttpServletRequest request) {
        System.out.println("Login GET URI Triggered");

        HttpSession session;
        ModelAndView mv = new ModelAndView();

        if ((session = request.getSession(false))!= null) {
            UserDisplay userDisplay;
            if ( (userDisplay = (UserDisplay) session.getAttribute("userDisplay")) != null) {
                mv.addObject("userDisplay", userDisplay);
                mv.setViewName("profile");
                return mv;
            }
        }
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView handleLoginEvent(@ModelAttribute AuthenticateUserRequest authenticateUserRequest, HttpServletRequest request) {
        System.out.println("Login POST URI Triggered");

        ModelAndView mv = new ModelAndView();
        UserDisplay userDisplay ;

        if ((userDisplay = userService.authenticateUser(authenticateUserRequest) )!= null ) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            session = request.getSession(true);
            session.setAttribute("userDisplay", userDisplay);

            mv.addObject("userDisplay", userDisplay);
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
            mv.setViewName("login");
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
