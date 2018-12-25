package com.demo.eureka.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod="getFallback")    // 如果当前调用的get()方法出现了错误，则执行fallback
    public String index(@PathVariable String name){
        if (name.indexOf("null") != -1) {
            throw new RuntimeException("输入名称有误！") ;
        }
        return "hello!" + name;
    }

    public String getFallback(@PathVariable("name") String name) {    // 此时方法的参数 与get()一致
        return "输入名称"+name+"有误!" ;
    }
}
