package com.blessing.core.repository;

import com.blessing.core.domain.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{
    final static Map<Long,Member> store = new HashMap<>();
    static Long sequence;

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }
}
