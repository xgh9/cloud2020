package com.xing.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class MyRule {
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
