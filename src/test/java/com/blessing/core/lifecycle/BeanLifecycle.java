package com.blessing.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycle {
    @Test
    public void test() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        NetworkConnection networkConnection = ac.getBean(NetworkConnection.class);
        ac.close();

    }


    @Configuration
    static class ApplicationConfiguration {
        @Bean
        public NetworkConnection networkConnection() {
            NetworkConnection networkConnection = new NetworkConnection();
            networkConnection.setUrl("https://naver.com");
            return networkConnection;
        }
    }


}
