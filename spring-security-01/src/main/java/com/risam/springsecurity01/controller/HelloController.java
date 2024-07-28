package com.risam.springsecurity01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    //spring-security自动保护接口要进行认知之后才能访问
    @GetMapping("/hello")
    public String hello(){
        log.info("------- hello security -------");
        return "hello spring security";
    }
}
