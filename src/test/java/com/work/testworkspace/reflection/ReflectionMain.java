package com.work.testworkspace.reflection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.assertj.core.api.Assertions.*;

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
 *     ( ㄴ Class.forName() 메서드는 : 클래스 '동적로딩(dynamic loading)' 기능 수행 가능.)
 *
 * 이런 식으로 메모리의 힙 영역에 저장되어 있는 어떤 클래스의 'Class 타입 객체'에 접근해서
 * 해당 클래스의 정보를 알아내고 이걸 이용해서 인스턴스를 생성하거나 메서드를 호출할 수도 있고 (접근제어자와 상관없이) 멤버변수에 직접 접근할 수도 있다.
 *
 * #[정리]
 * => 이렇게 어떤 사용하려는 클래스가 있는데, 그 클래스의 정보(ex: 자료형 등)을 모르는 상태에서
 * 그 클래스의 'Class 타입 객체'를 통해 클래스 정보를 가져와 활용하여 해당 클래스의 인스턴스를 생성하거나 메서드를 호출해 사용하는 것을
 * '리플렉션(Reflection)' 이라고 한다.
 *
 * #[리플렉션을 사용해야 하는 경우]
 * Class 클래스를 사용해서 인스턴스를 생성하는 것, 즉 'Class 타입 객체'에 접근해서 해당 클래스의 정보를 알아내고 수동으로 인스턴스를 생성해주는 것은(리플렉션) 필요하지 않다면 사용하지 않아야 한다.
 * 보통 방식으로 인스턴스 생성하기(클래스의 자료형을 직접 사용하여 인스턴스를 생성하는 것)보다 더 복잡하고 예외처리도 해야 한다.
 * 클래스정보를 이미 알고 있는 상황에서 리플렉션 프로그래밍을 하면 오히려 코드만 복잡해지고 속도도 느려진다.
 * 따라서 리플렉션 프로그래밍을 사용해야 하는 경우는
 * "어떤 클래스를 사용하긴 해야 하는데 이 클래스에 대한 정보를 컴파일 시점에 알 수 없을 때,
 * 즉 프로그램 실행 중에 클래스를 메모리에 로딩하거나, 객체가 다른 곳에 위치해서 원격으로 로딩하고 생성할 때 같은 경우"에 사용한다.
 *
 *
 * [ 동적 로딩(Dynamic Loading) ]
 * 클래스 정보는 대부분의 경우, 일반적으로 프로그램이 구동되었을 때 이미 메모리에 올라와 있다.
 * 근데 이렇게 처음부터 포함되어 있지 않고, 프로그램이 실행된 이후 별도로 (외부 환경설정파일 등으로부터 읽어들여) 클래스 정보를 가져와 메모리 로딩이 필요한 경우가 있다.
 * => 이렇게 프로그램 실행 이후 별도로 외부에서 클래스정보를 가져와 메모리에 불러오는 것을 '동적 로딩(Dynamic Loading)' 이라고 한다.
 *
 * 그리고 자바에서 이 동적로딩을 지원하는 메서드가 : Class.forName() 이다.
 * ex)
 * String className = "com.work.testworkspace.reflection.Member";
 * Class<?> memberClass = Class.forName(className);
 *
 * 위와 같이 Class.forName(className) 에 투입하는 매개변수 'className'이 변경되면
 * 결과로 얻는 'Class 타입 객체' memberClass 정보도 동적으로 변하게 할 수 있다.
 * ex) 이를 이용한 예시 : "여러 DB 드라이버 중 필요한 드라이버 값을 설정파일에서 읽어 문자열변수 className 로 할당해놓은 상황"
 *     이를 이용하면 설정파일 값을 변경함으로써 시스템에 적용되어지는 DB 드라이버를 간단하게 변경되게 할 수 있다.
 *
 * * */

public class ReflectionMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Member> memberClass = Member.class;
        System.out.println(System.identityHashCode(memberClass));

        Member member = new Member("jbkim", 31, "developing");
        Class<? extends Member> memberClass2 = member.getClass();
        System.out.println(System.identityHashCode(memberClass2));

        Class<?> memberClass3 = Class.forName("com.work.testworkspace.reflection.Member");
        System.out.println(System.identityHashCode(memberClass3));
    }

    @DisplayName("Member 클래스에 대해 Class 정보를 3가지 방식으로 얻은 결과값들이, 모두 동일한지 확인하기")
    @Test
    void test() throws ClassNotFoundException {
        Class<Member> memberClass = Member.class;
        Class<? extends Member> memberClass2 = new Member("jbkim", 31, "developing").getClass();
        Class<?> memberClass3 = Class.forName("com.work.testworkspace.reflection.Member");

        assertThat(System.identityHashCode(memberClass)).isEqualTo(System.identityHashCode(memberClass2));
        assertThat(System.identityHashCode(memberClass)).isEqualTo(System.identityHashCode(memberClass3));
        assertThat(System.identityHashCode(memberClass2)).isEqualTo(System.identityHashCode(memberClass3));
    }

    @Test
    void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
//        Method[] methods = aClass.getMethods();
//        for(Method m : methods) {
//            System.out.println(m);
//        }
//        System.out.println("aClass: " + aClass);

        String str = new String();
        Class<? extends String> strClass1 = str.getClass();
        Class<String> strClass2 = String.class;
        Class<?> strClass3 = Class.forName("java.lang.String"); // Class.forName("클래스명") 을 호출할 때 '클래스명'은 '풀경로(full path)'를 입력해줘야 한다.

//        System.out.println(System.identityHashCode(strClass1));
//        System.out.println(System.identityHashCode(strClass2));
//        System.out.println(System.identityHashCode(strClass3));

//        Method[] methods = strClass1.getMethods();
//        for(Method m : methods) {
//            System.out.println("[" + m.getName() + "]");
//            for(Parameter p : m.getParameters()) {
//                System.out.print(p.getType().toString() + " " + p.getName());
//            }
//            System.out.println();
//        }

        Method length = strClass1.getMethod("length");
        Integer result = (Integer)length.invoke("test1234");
//        Object result = length.invoke("test1234");
        assertThat(result).isEqualTo(8);

    }

}
