package com.blessing.core;

import com.blessing.core.domain.Grade;
import com.blessing.core.domain.Member;
import com.blessing.core.domain.Order;
import com.blessing.core.service.MemberService;
import com.blessing.core.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService service=ac.getBean("orderService",OrderService.class);
        MemberService memberService=ac.getBean("memberService",MemberService.class);
        Member member=new Member();
        member.setId(1L);
        member.setGrade(Grade.VIP);
        member.setName("MemberA");
        memberService.join(member);
        Order order = service.createOrder(1L, 20000, "item1");
        System.out.println("order = " + order);
    }
}
