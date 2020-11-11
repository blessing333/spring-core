package com.blessing.core.service;

import com.blessing.core.domain.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
