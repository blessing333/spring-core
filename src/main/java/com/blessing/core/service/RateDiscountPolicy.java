package com.blessing.core.service;

import com.blessing.core.domain.Grade;
import com.blessing.core.domain.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{
    private final int discountRate=10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return price * discountRate/100;
        else
            return 0;
    }
}
