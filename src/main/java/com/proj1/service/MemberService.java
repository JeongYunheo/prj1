package com.proj1.service;

import com.proj1.domain.Member;
import com.proj1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;

    public void signup(Member member) {
        mapper.insert(member);
    }
}
