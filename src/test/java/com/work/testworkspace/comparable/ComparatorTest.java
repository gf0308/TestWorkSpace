package com.work.testworkspace.comparable;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorTest {

    @Test
    void comparatorTest() {
        TreeSet<Integer> ts = new TreeSet<>(new DescendingOrder());
        ts.add(30);
        ts.add(40);
        ts.add(10);
        ts.add(20);

        Iterator<Integer> iter = ts.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

}
