package com.work.testworkspace.reflection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import static org.assertj.core.api.Assertions.*;

public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // 컴파일된 클래스파일 정보 (.class) 가져오는 방법 3가지
        Person person = new Person();
        Class<? extends Person> pClass1 = person.getClass();                                         // 1. 해당객체.getClass() 메서드 사용
        Class<Person> pClass2 = Person.class;                                                        // 2. 해당클래스명.class 사용
        Class<?> pClass3 = Class.forName("com.work.testworkspace.reflection.Person");   // 3. Class.forName("해당클래스 풀경로") 사용
//        System.out.println(pClass1.getName());                          // com.work.testworkspace.reflection.Person
//        System.out.println(pClass2.getName());                          // com.work.testworkspace.reflection.Person
//        System.out.println(pClass3.getName());                          // com.work.testworkspace.reflection.PersonSystem.out.println(pClass1.getName());                          // com.work.testworkspace.reflection.Person
        System.out.println(pClass1);                          // com.work.testworkspace.reflection.Person
        System.out.println(pClass2);                          // com.work.testworkspace.reflection.Person
        System.out.println(pClass3);                          // com.work.testworkspace.reflection.Person

        /** #[ 리플렉션(Reflection) 이란 ]
         * 프로그래밍을 하다보면 어떤 클래스를 사용하긴 해야 하는데 그 클래스에 대해 알아야 하는 정보(ex: 자료형 등)를 모르는 상황에서 사용해야 하는 경우가 생긴다.
         *  (ex: 그 클래스의 자료형[타입]이 뭔지 모르는 경우가 있음)
         *  (ex: 내 컴퓨터에 저장되어 있지 않은 객체를 메모리에 로드하고 생성하는 경우, 그 객체가 무슨 타입인지 알 수 없을 것임)
         * 이럴 때 그 클래스의 '힙 영역에 로드된 Class 타입의 객체'에 접근한다면, 거기에서 우리가 알고자 하는 정보들(그 클래스의 타입, 메서드, 필드, 생성자.. etc)을 알 수가 있다.
         * 이걸 활용하여 그 클래스의 인스턴스를 생성하거나 메서드를 호출해 사용하는 식의 방식을 '리플렉션(Reflection)' 이라고 한다.
         *
         * [리플렉션의 핵심 요소인 'Class 타입 객체'의 생성 원리]
         * 자바 애플리케이션이 실행되고 JVM 이 구동되면 JVM 의 Class Loader 는 클래스 파일(.class 파일)들을 전부 로딩한다.
         * 로딩이 완료된 후엔 해당 클래스(.class)의 정보를 담은 객체 'Class 타입 객체'( ex: Class<?> 객체 ) 를 생성한다. (*여기서의 Class 는 '.class 파일'할때의 class 를 의미하는듯)
         * 이 생성된 'Class 타입 객체'를 메모리의 힙(Heap) 영역에 저장한다. (이 'Class 타입 객체'엔 그 클래스에 대한 정보들이 담겨 있다.)
         *  -> "이 힙 영역에 저장돼있는 Class 타입 객체에 접근하면 그 클래스에 대한 정보를 알아낼 수 있게 됨."

         * [*Tip]
         * 자바 소스가 컴파일 되면 class 파일이 된다 ( A.java ---compile---> 'A.class' )
         * 컴파일된 상태인 '.class 파일' 안에는 그 자바클래스의 각종 정보들(멤버변수,메서드,생성자.. etc)이 들어있다.
         *   -> 어떤 클래스에 대해서 잘 모르고 있어도 이 class 파일의 정보에 접근할 수 있다면, 이 클래스의 정보들을 잘 알 수 있게 되는 것.

         * [리플렉션(Reflection)을 위해 'Class 타입 객체'에 접근하기]
         * 이 'Class 타입 객체' 에 접근하는 방법은 3가지다.
         * 1. 해당객체.getClass() 메서드 사용          ex) Class<? extends Person> pClass1 = new Person().getClass();
         * 2. 해당클래스명.class 사용                  ex) Class<Person> pClass2 = Person.class;
         * 3. Class.forName("해당클래스 풀경로") 사용  ex) Class<?> pClass3 = Class.forName("com.work.testworkspace.reflection.Person");
         *
         * 이런 식으로 메모리의 힙 영역에 저장되어 있는 어떤 클래스의 'Class 타입 객체'에 접근해서
         * 해당 클래스의 정보를 알아내고 이걸 이용해서 인스턴스를 생성하거나 메서드를 호출할 수도 있고 (접근제어자와 상관없이) 멤버변수에 직접 접근할 수도 있다.
         *
         * #[정리]
         * => 이렇게 어떤 사용하려는 클래스가 있는데, 그 클래스의 정보(ex: 자료형 등)을 모르는 상태에서
         * 그 클래스의 'Class 타입 객체'를 통해 클래스 정보를 가져와 활용하여 해당 클래스의 인스턴스를 생성하거나 메서드를 호출해 사용하는 것을
         * '리플렉션(Reflection)' 이라고 한다.
         * * */




    }


}
