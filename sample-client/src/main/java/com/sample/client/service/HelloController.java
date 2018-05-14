package com.sample.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam String name) {
        String serviceBody = restTemplate.getForObject("Http://SAMPLE-SERVICE/hi?name="+name,String.class);
        return serviceBody+" client port:"+port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry, service error!";
    }
}
