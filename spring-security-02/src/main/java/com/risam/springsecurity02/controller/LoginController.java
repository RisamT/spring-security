package com.risam.springsecurity02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {
    @RequestMapping("/login.html")
    public String login(){
        log.info("------- login --------");
        return "login";
    }
}
