package com.sample.service.Controller;

import com.sample.service.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by czy on 2018/4/22.
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        try{
//            Thread.sleep(10000L);
        }catch (Exception e){
            return "error 50x";
        }
        return "hi "+name+",i am service port:"+port;
    }
}
