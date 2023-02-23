package com.work.dependencyInjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    // Constructor Injection 방식
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Field Injection 방식
//    @Autowired
//    private MemberRepository memberRepository;

    // Setter Injection 방식
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }


    public String getMember(String memberName) {
        return memberRepository.selectMember(memberName);
    }

}
