package com.work.dependencyInjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@RequestMapping("/setterInjection")
//@Controller
public class SetterInjection {

    private MemberService memberService; // final 처리는 굳이 하지 않았다.

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/getMember")
    public String getMember(String memberName) {
        log.info("[test] " + getClass().getName() + "." + "getMember");

        return memberService.getMember(memberName);
    }

}
