package com.oneapp.user.config;

import com.oneapp.user.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    User getUserBean() {
        return new User();
    }
//    @Bean
//    @LoadBalanced // ribbon 负载均衡组件
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
}
