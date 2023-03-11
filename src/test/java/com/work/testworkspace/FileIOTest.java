package com.work.testworkspace;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;

public class FileIOTest {

//    @Test
    void test() {
        FileOutputStream fileOutputStream;
        String saveDestPath = "C:\\kjb\\works\\output_files\\output.txt";
        String str = "테스트 문자열 입니다.";
        byte[] bytes = str.getBytes();

        try {
            fileOutputStream = new FileOutputStream(saveDestPath);
            fileOutputStream.write(bytes);
        } catch(Exception e) {
            e.printStackTrace();
        }
//        fileOutputStream.close();

        System.out.println("쓰기 완료");
    }

}
