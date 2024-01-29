package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/response")
@Controller
public class ResponseController {
    // Content-Type: text/html
    // Response Body
    // {"name":"MinKyu", "age":95}
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"MinKyu\",\"age\":28}";
    }

    // Content-Type: application/json  // spring 내부에서 java형식을 반환할 때 이 방식으로 반환을 한다.(key, value)
    // 위에서 한것 처럼 text타입으로 변환을 매번 해줄 필요가 없다.
    // Response Body
    // {"name":"MinKyu", "age":95}
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClassJson() {
        return new Star("Minkyu",28);
    }
}
