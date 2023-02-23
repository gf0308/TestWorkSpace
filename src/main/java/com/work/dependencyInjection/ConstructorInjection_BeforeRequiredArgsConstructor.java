package com.work.dependencyInjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping("/constructorInjection")
@ResponseBody
//@Controller
public class ConstructorInjection_BeforeRequiredArgsConstructor {

    private final MemberService memberService;

    public ConstructorInjection_BeforeRequiredArgsConstructor(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/getMember")
    public String getMember(String memberName) {
        log.info("[test] " + getClass().getName() + "." + "getMember");

        return memberService.getMember(memberName);
    }

}
