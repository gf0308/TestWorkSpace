package com.work.testworkspace.nestedClass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NestedClassMain {

    @DisplayName("Inner Class(Non-Static Nested Class) Test")
    @Test
    void testInnerClass() {
        OuterClass outerClass = new OuterClass("jbkim", 31);
        outerClass.introduce();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.introduceInInner();
    }

    @DisplayName("Static Nested Class Test")
    @Test
    void testStaticNestedClass() {
        OuterClass outerClass = new OuterClass("jbkim", 31);
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        staticInnerClass.introduceInStaticInner();
    }

    @DisplayName("Method Local Inner Class Test")
    @Test
    void testMethodLocalInnerClass() {
        OuterClass outerClass = new OuterClass("jbkim", 31);
        outerClass.introduceByUsingLocalInnerClass();
    }

    @DisplayName("Anonymous Inner Class Test")
    @Test
    void testAnonymousInnerClass() {
        OuterClass outerClass = new OuterClass("jbkim", 31);
        outerClass.useAnonymousInnerClass();
    }
}
