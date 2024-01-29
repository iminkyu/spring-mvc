package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.GetExchange;

@Controller

public class HelloController {
    @GetMapping("/api/hello")
    @ResponseBody
    public String hello() {
        return "Hello World#########"; // 문자열로 반환 하게 되면 resources/templates 에서 html파일을 찾은 후 그 html을 반환
        //이후에 postman에서 /api/hello > send > return값 출력
    }
    @GetMapping("/api/get")
    @ResponseBody
    public String get() {
        return "Get Method 요청";
    }

    @PostMapping("/api/post")
    @ResponseBody
    public String post() {
        return "Post Method 요청";
    }



}

