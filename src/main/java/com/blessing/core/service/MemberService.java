package com.blessing.core.service;

import com.blessing.core.domain.Member;

public interface  MemberService {
    void join(Member member);
    Member findMember(Long id);
}
