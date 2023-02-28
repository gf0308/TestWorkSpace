package com.work.testworkspace.reflection;

public class Member {

    private String name;
    protected int age;
    public String hobby;

    public Member() {
    }

    public Member(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public void speak(String message) {
        System.out.println(message);
    }

    private void secret() {
        System.out.println("비밀번호는 1234입니다.");
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }

}