package com.kit.domitory.IocContainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonConfig {
    @Bean
    DeliveryService sharedService() {
        return new DeliveryService();
    }

}
