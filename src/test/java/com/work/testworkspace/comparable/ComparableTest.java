package com.work.testworkspace.comparable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ComparableTest {

    @Test
    void test() {
        Car car1 = new Car("아반떼", 2022, "스카이블루");
        Car car2 = new Car("소나타", 2017, "그레이블랙");
        Car car3 = new Car("그랜져", 2011, "블랙");
        Car car4 = new Car("BMW", 2010, "실버");
//        car1.compareTo(car2); // 1 예상
        assertThat(car1.compareTo(car2)).isEqualTo(1);
        assertThat(car4.compareTo(car3)).isEqualTo(-1);
        assertThat(car2.compareTo(car4)).isEqualTo(1);
    }

//    TreeSet TreeMap 은 생성자에서 Comparator를 받는 경우가 존재함.
    @DisplayName("맵 내의 객체들을 순서대로 정렬하기 테스트 중(가능한가?)")
    @Test
    void treeMapTest() {
        // 객체 순서 비교자 comparator 생성
        Comparator<Object> comparator = new Comparator<>() {
            @Override
            public int compare(Object obj1, Object obj2) {
                if (obj1 instanceof Comparable && obj2 instanceof Comparable) {
                    Integer intObj1 = (Integer) obj1;
                    Integer intObj2 = (Integer) obj2;
//                    return intObj1.compareTo(intObj2); // 오름차순
                    return intObj2.compareTo(intObj1); // 내림차순
                }
                return -1;
            }
        };

        Map<Integer, String> tMap = new TreeMap<Integer, String>(comparator); // 내림차순 comparator 주입
        tMap.put(33, "thirty-three");
        tMap.put(10, "ten");
        tMap.put(1, "one");
        tMap.put(50, "fifty");
        tMap.put(22, "twenty-two");
        tMap.put(31, "thirty-one");

        Set<Integer> intKeySets = tMap.keySet();
        for (Integer key : intKeySets) {
            System.out.println(key + " : " + tMap.get(key));
        }
//        Iterator<Integer> iters = intKeySets.iterator();
//        while(iters.hasNext()) {
//            Integer intKey = iters.next();
//            System.out.println(intKey + " : " + tMap.get(intKey));
//        }
    }

    @DisplayName("리스트 내 객체 순서 정렬 테스트(완료)")
    @Test
    void orderingListTest() {
        ArrayList<Student> students = new ArrayList<>();

        // 클래스 Student의 인스턴스들 생성 (* 클래스 Student 는 Comparable 인터페이스를 구현했다 : Comparable/Comparator 등을 활용해서 순서 정렬이 가능하도록)
        Student stu1 = new Student("60121111", "John");
        Student stu2 = new Student("60121112", "David");
        Student stu3 = new Student("60121113", "James");
        Student stu4 = new Student("60121114", "Lina");

        // 리스트에 마구잡이 순서로 add
        students.add(stu3);
        students.add(stu2);
        students.add(stu4);
        students.add(stu1);

        // 객체 정렬 해주는 Comparator 생성
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.compareTo(s2); // 오름차순
                //return s2.compareTo(s1); // 내림차순
            }
        };

        // Comparator 를 넣고 리스트 소트 하기
            // 방법1 : 코드 긴 버전으로 구현한 comparator 주입해넣기
            //students.sort(comparator);

            // 방법2 : 람다식으로 즉석구현해 넣기 : comparator 구현부 간단히 구현하기
//            students.sort((s1, s2) -> {
//                return s1.compareTo(s2); // 오름차순
//            });

            // 방법3 : 람다식으로 더 축약하기
            students.sort((s1, s2) -> s2.compareTo(s1) ); // 내림차순

        // 출력
        for (Student student : students) {
            System.out.println(student.getStudentNo() + ", " + student.getStudentName());
        }
    }


}
