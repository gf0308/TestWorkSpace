package com.work.dependencyInjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService_CircularReference2 {

    private MemberService_CircularReference1 service1;

    public MemberService_CircularReference2(MemberService_CircularReference1 service1) {
        this.service1 = service1;
    }

    public void doService2() {
        service1.doService1();
    }
}
