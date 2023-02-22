package com.work.testworkspace;

import lombok.ToString;
import org.junit.jupiter.api.Test;

public class ToStringTest {

    @Test
    void test() {
        ToStringSample toStringSample = new ToStringSample("name", "dev", 30);
        System.out.println("=======toStringSample.toString()=======");
        System.out.println(toStringSample.toString());
    }

    @Test
    void test2() {
        ToStringSample2 toStringSample2 = new ToStringSample2("name", "dev", 30);
        System.out.println("=======toStringSample2.toString()=======");
        System.out.println(toStringSample2.toString());
    }
}

@ToString // 롬복의 @ToString 을 적용하여 해당객체필드값들을 다 확인할수있게 문자열로 리턴해주는 toString 재정의 메서드를 자동생성
class ToStringSample2 {
    private String name;
    private String job;
    private int age;

    public ToStringSample2(String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }
}

class ToStringSample {
    private String name;
    private String job;
    private int age;

    public ToStringSample(String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    // toString 메서드는
    // (해당 메서드가 구현돼있는) 클래스 객체의 내용(필드값 내용)이 지금 어떻게 되는지 확인해보고 싶을 때
    // 메서드를 호출로 리턴된 문자열을 출력해봐서 디버깅 콘솔 등에서 확인해볼 수 있도록 보통 사용하는 기능이다.
    // 호출한 결과로 나오는 결과문자열은 보통 "클래스명{필드1=필드1값,필드2=필드2값,...}" 형태다.
    // 자바 최상위 객체 Object 에 정의되어져있기 때문에 어느 클래스에서나 (상속해서) 이용할 수 있다.
    // (물론 객체필드내용을 보여주도록 재정의하는 작업 필요하다; 안하면 해당객체의필드값이 아닌 객체의 hashCode 값 문자열을 리턴함)
    // ex) com.work.testworkspace.ToStringSample2@49438269
    @Override
    public String toString() {
        return "ToStringSample{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }


}