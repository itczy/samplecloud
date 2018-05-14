package com.sample.ribbon.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by czy on 2018/4/22.
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
//        return new WeightedResponseTimeRule();
        return new BestAvailableRule();
//        return new RoundRobinRule();
//        return new RandomRule();
    }

}
