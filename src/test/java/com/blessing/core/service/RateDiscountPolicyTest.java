package com.blessing.core.service;

import com.blessing.core.domain.Grade;
import com.blessing.core.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {
    DiscountPolicy policy = new RateDiscountPolicy();
    @Test
    void discount() {
        Member member=new Member();
        member.setId(1L);
        member.setName("Spring");
        member.setGrade(Grade.VIP);
        int discountPrice = policy.discount(member, 10000);
        assertThat(discountPrice).isEqualTo(1000);
    }
}