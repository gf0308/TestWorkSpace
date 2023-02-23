package com.work.dependencyInjection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    @DisplayName("의존성 주입 방식 3가지를 활용하여 getMember 메서드 호출 테스트")
    @Test
    void getMember() {
        // MemberService의 getMember 작동 테스트
        // [생성자 주입 방식 구현일 때]
        MemberService memberService = new MemberService(new MemberRepository());
        String memberResult = memberService.getMember("jbkim"); // member : jbkim
        assertThat(memberResult).isEqualTo("member : jbkim");
        // ok

        // [필드 주입 방식 구현일 때]
//        MemberService memberService = new MemberService();
//        Assertions.assertThatThrownBy(() -> {
//            memberService.getMember("jbkim");
//        }).isInstanceOf(NullPointerException.class); // org.assertj.core.api.Assertions 의 thrown by 기능 사용
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            memberService.getMember("jbkim");
//        }); //org.junit.jupiter.api.Assertions 의 throw 기능 사용

        // [수정자 주입 방식 구현일 때]
//        MemberService memberService = new MemberService();
//        memberService.setMemberRepository(new MemberRepository());
////        assertThatThrownBy(() -> {
////            memberService.getMember("jbkim");
////        }).isInstanceOf(NullPointerException.class);
//        String memberResult = memberService.getMember("jbkim");
//        assertThat(memberResult).isEqualTo("member : jbkim");
        // 수정자주입방식일 경우
        // 테스트코드에서 .set() 메서드로 객체 주입해서 테스트하는데 이용하는건 가능하지만 -> 코드에서 객체 수정을 허용한다는 취약점이 생김
    }
}