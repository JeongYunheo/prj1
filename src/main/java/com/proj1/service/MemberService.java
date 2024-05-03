package com.proj1.service;

import com.proj1.domain.CustomUser;
import com.proj1.domain.Member;
import com.proj1.mapper.BoardMapper;
import com.proj1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;
    private final BCryptPasswordEncoder encoder;
    private final BoardMapper boardMapper;

    public void signup(Member member) {
        member.setPassword(encoder.encode(member.getPassword()));

        mapper.insert(member);
    }

    public List<Member> list() {
        return mapper.selectAll();
    }

    public Member get(Integer id) {
        return mapper.selectById(id);
    }

    public void remove(Integer id) {
        // board 테이블에서 레코드 삭제
        boardMapper.deleteBoardByMemberId(id);

        // member 테이블에서 레코드 삭제
        mapper.delete(id);
    }

    public void modify(Member member) {
        mapper.update(member);
    }

    public String emailCheck(String email) {
        Member member = mapper.selectByEmail(email);

        if (member == null) {
            return "사용가능한 이메일입니다";
        } else {
            return "이미 존재하는 이메일입니다";
        }

    }

    public boolean hasAccess(Integer id, Authentication authentication) {
        if (authentication == null) {
            return false;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUser user) {
            Member member = user.getMember();
            return member.getId().equals(id);
        }
        return false;
    }
}
