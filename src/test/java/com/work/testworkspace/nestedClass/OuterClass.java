package com.work.testworkspace.nestedClass;

/**
 * [중첩클래스(Nested Class) 종류]
 *
 * #Nested Class : 중첩 클래스
 *  ## Static Nested Class : Static 중첩 클래스
 *  ## Inner Class : 내부 클래스
 *     ### Inner Class : 일반 내부 클래스 (Outer Class 안에 선언되어 있는 클래스[Inner Class])
 *     ### Method Local Inner Class : 한 메서드 내부에서 지역변수처럼 선언되어서 쓰이는 (내부) 클래스
 *     ### Anonymous Inner Class : 익명 내부 클래스; 기존에 존재하는 어떤 클래스를 new 해서 생성하고 중괄호{}를 전개해 바로 오버라이드 해서 만들어 쓰는 내부 클래스; 메서드 안에서 사용됨.
 *
 * */
public class OuterClass {

    private String name;
    private int age;
    private static final String THIS_CONTEXT = "TEST";

    public OuterClass(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void introduce() {
        System.out.println("Hello, I am " + this.name + ", and " + this.age + " years old.");
    }

    public void introduceByUsingLocalInnerClass() {
        String name = "jbkim_local";

        // Method Local Inner Class : 한 메서드 내부에서 지역변수처럼 선언되어서 쓰이는 (내부) 클래스
        class MethodLocalInnerClass {
            private String name;

            public MethodLocalInnerClass(String name) {
                this.name = name;
            }

            public void sayName() {
                System.out.println("[In MethodLocalInnerClass] " + this.name + "....!");
            }
        }

        MethodLocalInnerClass methodLocalInnerClass = new MethodLocalInnerClass(name);
        methodLocalInnerClass.sayName();
    }


    // Inner Class : 일반 내부 클래스 (Outer Class 안에 선언되어 있는 클래스[Inner Class])
    class InnerClass { // Non-Static Nested Class
        void introduceInInner() {
            System.out.println("[In Inner Class] Hello, I am " + name + ", and " + age + " years old...!");
        }
    }

    // Static Nested Class : Static 중첩 클래스
    static class StaticInnerClass { // Static Nested Class
        void introduceInStaticInner() {
            System.out.println("[In Static Inner Class] Hello, This is " + THIS_CONTEXT);
        }
    }


    class ChildOfTestClass extends TestClass {
        public ChildOfTestClass(String memberNo) {
            super(memberNo);
        }

        @Override
        public void sayMemberNo() {
            super.sayMemberNo();
            System.out.println("[In Override])");
        }
    }


    void useAnonymousInnerClass () {
        //Anonymous Inner Class : 익명 내부 클래스; 기존에 존재하는 어떤 클래스를 new 해서 생성하고 중괄호{}를 전개해 바로 오버라이드 해서 만들어 쓰는 내부 클래스; 메서드 안에서 사용됨.
        new TestClass("T0001") {
            @Override
            public void sayMemberNo() {
                super.sayMemberNo();
                System.out.println("[In Override])");
            }
        }.sayMemberNo();
    }

}
