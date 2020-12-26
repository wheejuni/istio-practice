package com.wheejuni.cloud.helloworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String getHelloWorldPage(Model model) {
        model.addAttribute("body", "this is fetched body.");

        return "hello";
    }
}
