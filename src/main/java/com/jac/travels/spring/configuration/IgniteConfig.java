package com.jac.travels.spring.configuration;

import com.jac.travels.ignite.IgniteDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteConfig {
    @Bean
    IgniteDemo igniteDemo() {
        IgniteDemo igniteDemo = new IgniteDemo();
        igniteDemo.startCache();
        return igniteDemo;
    }
}
