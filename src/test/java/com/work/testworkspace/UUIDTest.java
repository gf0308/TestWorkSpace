package com.work.testworkspace;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class UUIDTest {
    // Object.getClass() : 해당 object 의 runtime class 를 나타내는 class object 를 반환.

    @Test
    void test() {
        // java.util.UUID 패키지
        UUID uuid = UUID.randomUUID();
        System.out.println("uuid: " + uuid); // uuid: 06e1a869-0f77-41d5-9749-ff50c2552a4c
        System.out.println("uuid.getClass(): " + uuid.getClass());
        System.out.println("uuid.getClass().getName(): " + uuid.getClass().getName());

        String strUuid = uuid.toString();
        System.out.println("strUuid: " + strUuid);
//        String noDashUuid = strUuid.replaceAll("-", "");
//        System.out.println("noDashUuid: " + noDashUuid);

        assertThat(strUuid).isNotEqualTo((uuid));

        // 많이 사용하는 RID값 생성 방식
        String newRid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("newRid: " + newRid);
        System.out.println("newRid.length(): " + newRid.length());

    }
}
