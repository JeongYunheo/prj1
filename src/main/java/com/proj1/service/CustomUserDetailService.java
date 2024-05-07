package com.proj1.service;

import com.proj1.domain.CustomUser;
import com.proj1.domain.Member;
import com.proj1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = mapper.selectByEmail(username);
        if (member == null) {
            throw new UsernameNotFoundException(username);
        }

        List<String> authority = mapper.selectAuthorityNamesByMemberId(member.getId());

        member.setAuthority(authority);

        return new CustomUser(member);
    }
}
