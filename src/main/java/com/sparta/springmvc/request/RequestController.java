package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 필드 제대로 맞췄는지
// Getter 유무
// Setter 유무

@Controller
@RequestMapping("/hello/request")
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "Hello-Request-Form";
    }
    // [Request sample]
    // GET http://localhost:8080/hello/request/star/MinKyu/age/28
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }
    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param?name=MinKyu&age=28
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
    // POST http://localhost:8080/hello/request/form/param
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body
    //  name=MinKyu&age=28
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
    // POST http://localhost:8080/hello/request/form/model
    // Header
    // Content type: application/x-www-form-urlencoded
    // Body
    // name=MinKyu&age=28
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param/model?name=MinKyu&age=28
    //@ModelAttribute 도 생략이 가능한데 SimpleValueType 으로 받을경우 @RequestParam 을 생략했다고 간주, Class 나 Object 일때는 @ModelAttribute 으로 간주
    @GetMapping("/form/param/model")
    @ResponseBody
    public String helloRequestParam(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    // [Request sample]
    // POST http://localhost:8080/hello/request/form/json
    // Header
    //  Content type: application/json
    // Body
    //  {"name":"MinKyu","age":"28"}
    // JSON 형식으로 받을 경우 parameter 앞에 @RequestBody 꼭 붙여야함.
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
}
