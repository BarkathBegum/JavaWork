package rest.application.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/grocery-shop")
public class GreetingController {

    @GetMapping
    public String greet(){
        return "Welcome to "+ LocalDate.now().getDayOfWeek()+" sale!";
    }
}