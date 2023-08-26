package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.entity.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("HelloWorld");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorld helloWorldPathVariable(@PathVariable String name){
        return new HelloWorld("HelloWorld " + name);
    }
}
