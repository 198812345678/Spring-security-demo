package com.will.simple.security.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/info", produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {

               Map<String, Object> userInfo = new HashMap<>();

               userInfo.put("user", user.getUserAuthentication().getPrincipal());

               userInfo.put("authorities", AuthorityUtils.authorityListToSet(

                user.getUserAuthentication().getAuthorities()));

               return userInfo;

    }

}
