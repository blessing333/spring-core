package com.blessing.core.service;

import com.blessing.core.domain.Grade;
import com.blessing.core.domain.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private final double discountRate=10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return price*10/100;
        else
            return 0;
    }
}
