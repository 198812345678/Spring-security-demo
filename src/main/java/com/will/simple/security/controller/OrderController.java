package com.will.simple.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @RequestMapping(value = "/info", produces = "application/json")
    public Map<String, Object> orderInfo(@RequestParam String id) {

        Map<String, Object> order = new HashMap<>();

        order.put("id", id);

        oAuth2RestTemplate.exchange("http://localhost:8080/order/test?", HttpMethod.GET, null, Object.class);

        return order;

    }

    @RequestMapping(value = "/test", produces = "application/json")
    public Map<String, Object> test() {

        Map<String, Object> order = new HashMap<>();

        System.out.println("==============");

        return order;

    }
}
