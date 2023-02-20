package com.work.testworkspace;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TestClass2 {

    @Test
    void test() {
        TestRestTemplate resTmp = new TestRestTemplate();
//        resTmp.postForEntity(URL, requestObject, responseTypeClass);

    }


    public boolean checkUser(HttpServletRequest request, String applicationId, String accountId, String userId) {
        HttpSession session = request.getSession();
        UserVo userVo = (UserVo)session.getAttribute("USER_DATA");

        if( userVo != null && isNotEmpty(userId) && userId.equals(userVo.getSysId()) ) {
            return true;
        }

        if( userVo != null && userId == null ) {
            return true;
        }

        if(!( isNotEmpty(applicationId) && isNotEmpty(accountId) && isNotEmpty(userId) )) {
            throw new UnauthorizedAccessException();
        }

        UserVo reqVo = UserVo.builder()
                .applicationId(applicationId)
                .accountId(accountId)
                .userId(userId)
                .build();
        UserVo resVo = this.getUserDetail(reqVo);

        if( resVo != null ) {
            session.setAttribute("USER_DATA", resVo);
            session.setAttribute("userId", resVo.getSysId());
            session.setAttribute("userName", resVo.getEmpName());
        }

        return true;
    }





    public boolean isNotEmpty(String param) {
        return !(param == null || param.length() == 0);
    }

    public UserVo getUserDetail(UserVo reqVo) {
        return UserVo.builder().build();
    }

    @Builder
    @Getter
    @Setter
    static class UserVo {
        private String applicationId;
        private String accountId;
        private String userId;
        private String sysId;
        private String userName;
        private String tenantType;
        private String tenantCode;
        private String empNo;
        private String empName;
    }

    static class UnauthorizedAccessException extends RuntimeException {
        public UnauthorizedAccessException() {
            super("잘못된 접근입니다.");
        }
    }

}
