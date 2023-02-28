package com.work.testworkspace.reflection;

public class NewInstanceTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Person person1 = new Person();
        System.out.println(person1);

        Class<?> pClass = Class.forName("com.work.testworkspace.reflection.Person"); // Person.class 의 'Class 타입 객체'(메모리 힙 영역에 저장돼있는) 를 가져옴
        Person person2 = (Person)pClass.newInstance(); // Class 클래스의 .newInstance() 로 인스턴스를 생성하면 해당 클래스의 디폴트 생성자를 호출하여 인스턴스를 생성한다.
        System.out.println(person2);

        // Class 클래스를 사용해서 인스턴스를 생성하는 것, 즉 'Class 타입 객체'에 접근해서 해당 클래스의 정보를 알아내고 수동으로 인스턴스를 생성해주는 것은(리플렉션) 필요하지 않다면 사용하지 않아야 한다.
        // 보통 방식으로 인스턴스 생성하기(클래스의 자료형을 직접 사용하여 인스턴스를 생성하는 것)보다 더 복잡하고 예외처리도 해야 한다.
        // 클래스정보를 이미 알고 있는 상황에서 리플렉션 프로그래밍을 하면 오히려 코드만 복잡해지고 속도도 느려진다.
        // 따라서 리플렉션 프로그래밍을 사용해야 하는 경우는
        // 어떤 클래스를 사용하긴 해야 하는데 이 클래스에 대한 정보를 컴파일 시점에 알 수 없을 때,
        // 즉 프로그램 실행 중에 클래스를 메모리에 로딩하거나, 객체가 다른 곳에 위치해서 원격으로 로딩하고 생성할 때 같은 경우에 사용한다.


    }
}
