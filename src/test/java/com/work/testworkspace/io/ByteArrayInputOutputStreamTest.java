package com.work.testworkspace.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayInputOutputStreamTest {

    @DisplayName("바이트배열에 대해 데이터 입출력을 수행하는 바이트기반스트림 ByteArrayInputStream, ByteArrayOutputStream 을 테스트한다")
    @Test
    void test() throws IOException {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream(); // ByteArrayOutputStream 객체는 디폴트생성자로도 생성할 수 있음; 디폴트생성자일 경우 인자값(buffer capacity)은 32 (32byte) 임.
        int data = 0;

        // 인풋스트림내용을 읽어들여서 아웃풋스트림쪽으로 write 한다
        // 방법1
        while((data = input.read()) != -1) {
            output.write(data);
        }
        // 방법2
        //output.write(input.readAllBytes());

        // 아웃풋스트림내용을 바이트배열로 변환한다
        outSrc = output.toByteArray();

        // 콘솔창에서 결과 확인하기
        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("Output Source : " + Arrays.toString(outSrc));
    }

    @DisplayName("ByteArrayInputStream, ByteArrayOutputStream 을 테스트 2")
    @Test
    void test2() {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp = new byte[4]; // temp로 삼을 바이트배열 (buffer capacity : 4)
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        try {
            while(input.available() > 0) {
                input.read(temp); // 바이트배열[] temp 의 크기만큼(4) 인풋스트림에서 읽어들여서 temp에 저장해넣는다.
                output.write(temp); // 그 temp 의 내용을 그대로 아웃풋스트림에 밀어넣어 저장해넣는다.
        //                Input Source  : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        //                temp          : [8, 9, 6, 7]
        //                Output Source : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 7]

//                int len = input.read(temp);
//                output.write(temp, 0, len);
        //                Input Source  : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        //                temp          : [8, 9, 6, 7]
        //                Output Source : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
            }
        } catch(IOException e) { e.printStackTrace(); }

        outSrc = output.toByteArray();

        System.out.println("Input Source  : " + Arrays.toString(inSrc));
        System.out.println("temp          : " + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));
    }


}
