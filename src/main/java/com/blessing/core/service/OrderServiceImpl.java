package com.blessing.core.service;

import com.blessing.core.domain.Member;
import com.blessing.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    MemberService memberService;
    DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberService memberService, DiscountPolicy discountPolicy) {
        this.memberService = memberService;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, int itemPrice, String itemName) {
        Member member = memberService.findMember(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
