package com.ssb.vitalsoft.controller;

import com.ssb.vitalsoft.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
        String token= userService.login(username,password);
        if(StringUtils.isEmpty(token)){
            return "no token found";
        }
        return token;
    }
}