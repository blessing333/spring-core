package com.blessing.core;

import com.blessing.core.service.OrderService;
import com.blessing.core.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    public void test(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AutoAppConfig.class);
        OrderService service=ac.getBean(OrderServiceImpl.class);
        Assertions.assertThat(service).isInstanceOf(OrderServiceImpl.class);
    }
}
