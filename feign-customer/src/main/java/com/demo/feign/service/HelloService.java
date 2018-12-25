package com.demo.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="eureka-client-producer")
public interface HelloService {

    @GetMapping("/hello/{name}")
    String hello(@PathVariable("name") String name);

}
