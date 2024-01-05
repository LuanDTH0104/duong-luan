package com.org.clockshop.controller;

import com.org.clockshop.model.CustomUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/logout")
    public String getLogoutPage(){
        return "login";
    }

    @GetMapping("/auth")
    public String auth(Model model, Principal principal, Authentication authentication){
        String username = principal.getName();

        CustomUser user = (CustomUser)authentication.getPrincipal();
        System.out.println(user.toString());

        model.addAttribute("username",username);
        model.addAttribute("userRole",authentication.getAuthorities());
        return "testHTML";
    }

}
