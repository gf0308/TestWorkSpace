package com.work.dependencyInjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService_CircularReference1 {

    private MemberService_CircularReference2 service2;

    public MemberService_CircularReference1(MemberService_CircularReference2 service2) {
        this.service2 = service2;
    }

    public void doService1() {
        service2.doService2();
    }

}
