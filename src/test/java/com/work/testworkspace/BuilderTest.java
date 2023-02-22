package com.work.testworkspace;

import lombok.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BuilderTest {

    @Test
    void test() {
        TestBuilder testBuilder1 = new TestBuilder("kjb",31, 12323L);
        TestBuilder testBuilder2 = TestBuilder.builder()
                                        .name("kjb")
                                        .age(31)
                                        .created(12323L)
                                        .build();
        // 이런 빌더패턴이란건 결국
        // 객체를 생성하며 초기화할 필드를 명시적으로 직접 표시해가며 초기화값을 넣어주면서, 초기화값이 들어가야할 곳에 정확히 들어갈 수 있도록 하면서 객체가 생성되도록 강하게 유도하는 객체 생성 방식인 것이다.
        // 그리고 이게 가능하도록 구현시키는 내부 원리는
        // 원본 객체의 필드들과 동일하게 필드를 가지는 중첩클래스를 만들고
        // 그 중첩클래스에서 자기 자신의 필드들에 초기화를 해주는 '필드명'으로 된 세팅역할 메서드들을 각각 만들어놓고(마지막엔 return this 처리 하는)
        // 필요한 필드값 세팅이 모두 완료되면 여태 세팅완료된 필드들을 생성자의 파라미터로 순서대로 넣어 원본객체의 인스턴스를 생성해 반환하도록 하는 build 라는 메서드를 만들어놓는 것이다.

        assertThat(testBuilder2.getName()).isEqualTo(testBuilder1.getName());
        assertThat(testBuilder2.getAge()).isEqualTo(testBuilder2.getAge());
        assertThat(testBuilder2.getCreated()).isEqualTo(testBuilder1.getCreated());
        // 테스트 성공
    }

    @Test
    void easyBuilderTest() {
        Sample sample1 = new Sample("name", 31, 1232132L);
        Sample sample2 = Sample.builder()
                            .name("name")
                            .age(31)
                            .created(1232132L)
                            .build();

        assertThat(sample2.getName()).isEqualTo(sample1.getName());
        assertThat(sample2.getAge()).isEqualTo(sample1.getAge());
        assertThat(sample2.getCreated()).isEqualTo(sample1.getCreated());
    }
    
}

// 롬복에서 제공해주는 @Builder 를 적용해서 쉽게 빌더패턴 식 인스턴스 생성을 할 클래스 Sample
@Builder
@Getter
@Setter
class Sample {
    private String name;
    private int age;
    private long created;
}


// 테스트용 제작 빌더 패턴 클래스 (수동구현)
class TestBuilder {

    private String name;
    private int age;
    private long created;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public TestBuilder(String name, int age, long created) {
        this.name = name;
        this.age = age;
        this.created = created;
    }

    public static TestBuilderBuilder builder() {
        return new TestBuilderBuilder();
    }

    public static class TestBuilderBuilder {
        private String name;
        private int age;
        private long created;

        public TestBuilderBuilder() {
        }

        public TestBuilderBuilder name(String name) {
            this.name = name;
            return this;
        }
        public TestBuilderBuilder age(int age) {
            this.age = age;
            return this;
        }
        public TestBuilderBuilder created(long created) {
            this.created = created;
            return this;
        }

        public TestBuilder build() {
            return new TestBuilder(name, age, created);
        }
    }

}
