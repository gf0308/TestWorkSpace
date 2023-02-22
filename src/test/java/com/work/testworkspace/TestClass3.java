package com.work.testworkspace;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TestClass3 {

    // 파일업로드 시 권한체크 checkUser 메서드 기능 구현
    public boolean checkUser(HttpServletRequest request, String applicationId, String accountId, String userId) {
        HttpSession session = request.getSession(); // request.getSession(true) 와 동일.

        UserVo userVo = (UserVo) session.getAttribute("USER_DATA");

        if( userVo != null && userId != null && userId.equals(userVo.getSysId()) ) {
            return true;
        }

        if( userVo != null && userId == null ) {
            return true;
        }

        if( isEmpty(applicationId) || isEmpty(accountId) || isEmpty(userId) ) {
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

    public UserVo getUserDetail(UserVo reqVo) {
        reqVo.setSysId("sysId_test");
        reqVo.setEmpName("empName_test");
        return reqVo;
    }

    // isNotEmpty method
    static boolean isNotEmpty(String param) {
        return !(param == null || param.length() == 0);
    }
    // isEmpty method
    static boolean isEmpty(String param) {
        return (param == null || param.length() == 0);
    }
}


class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException() {
        super("잘못된 접근입니다.");
    }
}

@Getter
@Setter
@Builder
class UserVo {
    private String applicationId;
    private String accountId;
    private String userId;
    private String sysId;
    private String tenantType;
    private String tenantCode;
    private String empNo;
    private String empName;

}