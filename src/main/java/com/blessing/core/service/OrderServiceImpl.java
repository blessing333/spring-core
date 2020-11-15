package com.blessing.core.service;

import com.blessing.core.domain.Member;
import com.blessing.core.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberService memberService;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, int itemPrice, String itemName) {
        Member member = memberService.findMember(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
