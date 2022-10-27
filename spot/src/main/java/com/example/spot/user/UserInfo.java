package com.example.spot.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfo {

    @GetMapping("/hello")
    public Principal get(Principal principal) {
        return principal;
    }


}