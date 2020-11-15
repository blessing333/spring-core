package com.blessing.core;

import com.blessing.core.domain.Grade;
import com.blessing.core.domain.Member;
import com.blessing.core.service.DiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "UserA", Grade.VIP);
        int discount = discountService.discount(member, 20000, "rateDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discount).isEqualTo(2000);
    }


    static class DiscountService {
        private List<DiscountPolicy> discountPolicies;
        private Map<String, DiscountPolicy> policyHashMap;

        public DiscountService(List<DiscountPolicy> discountPolicies, Map<String, DiscountPolicy> policyHashMap) {
            this.discountPolicies = discountPolicies;
            this.policyHashMap = policyHashMap;
            System.out.println("discountPolicies = " + discountPolicies);
            System.out.println("policyHashMap = " + policyHashMap);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyHashMap.get(discountCode);
            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);
            return discountPolicy.discount(member, price);
        }
    }
}
