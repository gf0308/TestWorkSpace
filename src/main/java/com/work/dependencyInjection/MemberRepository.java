package com.work.dependencyInjection;

import org.springframework.stereotype.Repository;

//@Repository
public class MemberRepository {

    public String selectMember(String memberName) {
        return "member : " + memberName;
    }
}
