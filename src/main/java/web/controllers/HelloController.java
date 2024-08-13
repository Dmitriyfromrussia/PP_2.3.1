package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController { // пишем в множественном числе

    @GetMapping("/hello-page")
    public String presentation() {
        return "hello-page";
    }
}
