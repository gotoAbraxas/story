package com.example.story.member.service;


import com.example.story.domain.member.entity.Member;
import com.example.story.domain.member.repository.MemberRepository;
import com.example.story.domain.member.request.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;



    public Member signup(MemberRequest signup) {
        findByEmail(signup.getEmail());
        Member member = memberRepository.save(signup.toEntity());

        return member;
    }



// 더 구체적일수록 밑에.

    public Member findByEmail(String email) {
        Optional<Member> memberByEmail = memberRepository.findByEmail(email);

        return memberByEmail.orElseThrow(()-> new RuntimeException("이미 존재하는 이메일"));
    }

    public Member findById(Long id) {
        Optional<Member> memberById = memberRepository.findById(id);

        return memberById.orElseThrow(() -> new RuntimeException("아이디 못찾음"));
    }
}
