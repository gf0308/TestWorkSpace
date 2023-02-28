package com.work.testworkspace.comparable;

import java.util.Comparator;
import java.util.TreeMap;

public class AscendingOrder implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Integer c1 = (Integer) o1;
            Integer c2 = (Integer) o2;
            return c1.compareTo(c2);
        }
        return -1;
    }
}
