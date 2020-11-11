package com.blessing.core.service;

import com.blessing.core.domain.Grade;
import com.blessing.core.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    private final int  discountFixAmount= 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }
        else{
            return 0;
        }

    }
}
