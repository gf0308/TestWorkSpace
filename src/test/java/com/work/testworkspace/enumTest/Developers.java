package com.work.testworkspace.enumTest;

public enum Developers {
    // 열거형 Developers 항목들 : BACKEND_DEVELOPER / FRONTEND_DEVELOPER / DEVOPS_DEVELOPER
    // 각 상수별로 가질 속성(field) 들 : key, name
    BACKEND_DEVELOPER(10, "서버 사이드 개발"),
    FRONTEND_DEVELOPER(12, "화면 단 프론트 사이드 개발"),
    DEVOPS_DEVELOPER(15, "CI/CD 구축 및 유지보수 수행")
    ;

    private final int key;
    private final String role;

    Developers(int key, String role) {
        this.key = key;
        this.role = role;
    }

    public int getKey() {
        return key;
    }
    public String getRole() {
        return role;
    }
}
