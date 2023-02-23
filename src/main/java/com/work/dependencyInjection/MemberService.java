package com.work.dependencyInjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

    public String getMember(String memberName) {
        return memberName;
    }

}
