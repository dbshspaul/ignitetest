package com.jac.travels.spring.configuration;

import com.jac.travels.ignite.IgniteClientNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteConfig {
    @Bean
    IgniteClientNode igniteClientNode() {
        IgniteClientNode igniteClientNode = new IgniteClientNode();
        igniteClientNode.startCache();
        return igniteClientNode;
    }
}
