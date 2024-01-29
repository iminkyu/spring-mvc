package com.sparta.springmvc.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// RestController 를 사용하면 앞서 붙였던 @ResponseBody 를 붙일 필요가 없다 모든것에 ResponseBody 를 붙이기위해 사용.
// view를 반환해야하기 때문에 controller, data 반환위해 ResponseBody 를 붙임
// 전체 메소드가 JSON 형태를 반환한다면 Rest ....

@RequestMapping("/response/rest")
public class ResponseRestController {
    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    //   {"name":"Robbie","age":95}
    @GetMapping("/json/string")
    public String helloStringJson() {
        return "{\"name\":\"Minkyu\",\"age\":28}";
    }

    // [Response header]
    //   Content-Type: application/json
    // [Response body]
    //   {"name":"Robbie","age":95}
    @GetMapping("/json/class")
    public Star helloClassJson() {
        return new Star("MinKyu", 28);
    }
}