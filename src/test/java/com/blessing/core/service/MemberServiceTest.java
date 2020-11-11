package com.blessing.core.service;

import com.blessing.core.AppConfig;
import com.blessing.core.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {
    MemberService service;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.service = appConfig.memberService();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setId(1L);
        member.setName("Spring");
        service.join(member);
        Member serviceMember = service.findMember(1L);
        assertThat(member).isEqualTo(serviceMember);
    }

    @Test
    void findMember() {
        Member member = new Member();
        member.setId(2L);
        member.setName("Spr");
        service.join(member);
        Member member1 = service.findMember(2L);
        System.out.println("member1 = " + member1);
    }
}