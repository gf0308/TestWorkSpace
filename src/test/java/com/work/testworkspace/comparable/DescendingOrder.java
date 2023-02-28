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
 *
 * **/

public class DescendingOrder implements Comparator<Integer> {

    // TreeSet TreeMap 은 생성자에서 Comparator를 받는 경우가 존재함.



    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
