package com.work.testworkspace;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TestClass {
    static public String SESSION_KEY_USER_DATA = "USER_DATA";

    @Test
    boolean chkUsr(HttpServletRequest request, String applicationId, String accountId, String userId) {
        HttpSession session = request.getSession();
        UserVo userVo = (UserVo)session.getAttribute(SESSION_KEY_USER_DATA);

        if(userVo != null && userId != null && userId.equals(userVo.getSysId())) {
            return true;
        }

        if(userVo != null && userId == null) {
            return true;
        }

        if(!(isNotEmpty(applicationId) && isNotEmpty(accountId) && isNotEmpty(userId))) {
            // 미권한에러 : UnauthorizedAccessException
            throw new UnauthorizedAccessException();
        }

        UserVo reqVo = UserVo.builder()
                .applicationId(applicationId)
                .accountId(accountId)
                .userId(userId)
                .build();
        UserVo detailVo = this.getUserDetail(reqVo);

        if(detailVo != null) {
            session.setAttribute(SESSION_KEY_USER_DATA, detailVo);
            session.setAttribute("userId", detailVo.getUserId());
            session.setAttribute("userName", detailVo.getUserName());
        }
        return true;
    }

    static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    static boolean isNotEmpty(String str) {
        return !(str == null || str.length() == 0);
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

    static class UnauthorizedAccessException extends RuntimeException {}


    public UserVo getUserDetail(UserVo reqVo) {
//        return new UserVo();
        return null;
    }



}
