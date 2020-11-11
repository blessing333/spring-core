package com.blessing.core.repository;

import com.blessing.core.domain.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
}
