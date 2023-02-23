package com.work.dependencyInjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@RequestMapping("/fieldInjection")
@Controller
public class FieldInjection {

    @Autowired
    private MemberService memberService; // final 처리는 굳이 하지 않았다.

    @PostMapping("/getMember")
    public String getMember(String memberName) {
        log.info("[test] " + getClass().getName() + "." + "getMember");

        return memberService.getMember(memberName);
    }

}
