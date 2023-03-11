package com.work.dependencyInjection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/constructorInjection")
@RequiredArgsConstructor
@ResponseBody
//@Controller
public class ConstructorInjection {

    private final MemberService memberService;

    @PostMapping("/getMember")
    public String getMember(String memberName) {
        log.info("[test] " + getClass().getName() + "." + "getMember");

        return memberService.getMember(memberName);
    }

}


