package com.mvc.controller.building;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BuildingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingApplication.class, args);
    }

    @GetMapping("/main")
    public String mainPage(@RequestParam(value = "pageName", defaultValue = "Main") String name) {
        return String.format("Welcome to %s !", name);
    }

}
