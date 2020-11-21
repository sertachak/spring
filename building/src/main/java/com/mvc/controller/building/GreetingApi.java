package com.mvc.controller.building;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingApi {

    @GetMapping
    public String greeting(@RequestParam ( value = "name", defaultValue = "stranger") String name ) {
        return "Greetings" + " " + name;
    }
}
