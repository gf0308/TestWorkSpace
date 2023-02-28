package com.work.testworkspace.comparable;

import java.util.*;

/**
 * Comparator 는 인터페이스다
 * Comparator 인터페이스는 Comparable 과 같이 어떤 클래스 인스턴스 간에 비교해야하는 경우가 있을 때 비교를 수행할 수 있도록
 * 해당 클래스에 적용해서 구현시키는 인터페이스다.
 * Comparable 과 마찬가지로 .compareTo() 메서드를 상속받아 재정의하게 한다.
 *
 * Comparable 과의 차이점은 오름차순 말고 내림차순, 혹은 다른 방식으로도 객체가 정렬되도록 할 수 있다는 것이다.
 * 즉 Comparable 에서의 기본순서인 오름차순 순서가 아닌, 내림차순이나 다른 기준으로도 정렬이 가능하도록 구현이 가능하다.
 *
 *
 * **/
// TreeSet TreeMap 은 생성자에서 Comparator 를 받는 경우가 존재함.
public class DescendingOrder implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        /**
         * Wrapper 클래스 Integer 는 Comparable 인터페이스를 구현하고 있다!
         * ex) public final class Integer extends Number implements Comparable<Integer> { ... }
         *
         * - 자바에선 같은 타입의 인스턴스를 서로 비교해야만 하는 클래스들은 모두 Comparable 인터페이스를 구현하고 있음.
         * - 따라서 Wrapper 클래스들('Boolean' 마저도 포함) 은 모두 Comparable 인터페이스 구현 상태이며, 따라서 객체 정렬이 가능하다 (Boolean 객체만 제외하고)
         * */

        if(o1 instanceof Comparable && o2 instanceof Comparable) {
            Integer c1 = (Integer) o1;
            Integer c2 = (Integer) o2;
            return c2.compareTo(c1); // 내림차순 수행
        }

        return -1;
    }
}
