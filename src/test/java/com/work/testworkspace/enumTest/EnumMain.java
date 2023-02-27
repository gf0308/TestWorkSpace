package com.work.testworkspace.enumTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class EnumMain {
    @Test
    void test() {
        System.out.println(Rainbow.RED.getKey());
        System.out.println(Rainbow.RED.getName());
    }

    @Test
    void testWeek() {
        assertThat(Week.valueOf("MONDAY").ordinal()).isEqualTo(0);
        assertThat(Week.valueOf("TUESDAY").ordinal()).isEqualTo(1);
        assertThat(Week.valueOf("SUNDAY").ordinal()).isEqualTo(6);
    }

    @Test
    void testDevelopers() {
        assertThat(Developers.BACKEND_DEVELOPER.getKey()).isEqualTo(10);
        assertThat(Developers.FRONTEND_DEVELOPER.getKey()).isEqualTo(12);
        assertThat(Developers.DEVOPS_DEVELOPER.getKey()).isEqualTo(15);
    }
}
