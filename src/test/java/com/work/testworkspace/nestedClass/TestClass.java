package com.work.testworkspace.nestedClass;

public class TestClass {
    private String memberNo;

    public TestClass(String memberNo) {
        this.memberNo = memberNo;
    }

    public void sayMemberNo() {
        System.out.println("memberNo: " + this.memberNo);
    }

}
