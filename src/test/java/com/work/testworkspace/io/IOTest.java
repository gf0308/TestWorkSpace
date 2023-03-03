package com.work.testworkspace.io;

import org.junit.jupiter.api.Test;

import javax.sound.sampled.AudioInputStream;
import java.io.*;


public class IOTest {

    @Test
    void test() throws IOException {
        // 기반 스트림 입출력
        FileInputStream fis = new FileInputStream("test.txt"); // "test.txt"
        int read = fis.read();

        // 보조스트림 까지 사용한 입출력
        FileInputStream fis2 = new FileInputStream("test.txt"); // "test.txt"
        BufferedInputStream bis = new BufferedInputStream(fis2);
        bis.read();




    }

}

/**
 * 스트림(Stream) 이란
 * : 자바에서 데이터 입출력 때 쓰이는 기술
 *   (데이터를 운반할 때 사용되는 데이터운반통로;다리)
 *
 * 자바 입출력 스트림의 종류
 * - 기반 스트림(일반 스트림) (바이트기반 스트림, 문자기반 스트림 등 독자적으로 쓰일 수 있는 스트림)
 *   -- 사용하는 방법:    1) 기반스트림을 생성한다
 *                          ex) FileInputStream fis = new FileInputStream("test.txt");
 *                       2) 생성된 기반스트림으로 데이터를 입출력한다
 *                          ex) fis.read();
 * - 보조 스트림(일반 스트림의 기능을 향상시키거나 기존 스트림에 새로운 기능을 추가하기 위해 보조적으로 쓰이는 스트림, 혼자서는 쓰일 수 없음; 즉 독립적으로 입출력을 수행할 수 없다)
 *   -- 사용하는 방법:   1) 먼저 기반 스트림을 생성한다.
 *                             ex) FileInputStream fis = new FileInputStream("test.txt");
 *                      2) 기반스트림을 이용해서 보조스트림을 생성한다
 *                              ex) BufferedInputStream bis = new BufferedInputStream(fis);
 *                      3) 생성완료된 보조스트림으로 데이터를 입출력한다
 *                              ex) bis.read();
 *
 * 상세
 * - 바이트기반 스트림 : 바이트기반스트림의 최고조상 - 추상클래스 InputStream, OutputStream
 *  -- 바이트기반 스트림
 *    --- FileInputStream, FileOutputStream : '파일' 대상 입출력 스트림
 *    --- ByteArrayInputStream, ByteArrayOutputStream : '메모리' 대상 입출력 스트림
 *    --- PipedInputStream, PipedOutputStream : '프로세스' 대상 입출력 스트림
 *    --- AudioInputStream, AudioOutputStream : '오디오 장치' 대상 입출력 스트림
 *  -- 바이트기반 보조스트림
 *
 * - 문자기반 스트림
 *  -- 문자기반 스트림
 *  -- 문자기반 보조스트림
 *
 * 바이트기반 스트림
 * : 데이터를 바이트(byte)단위로 주고 받음
 * (추상클래스)
 * - InputStream
 * - OutputStream
 *
 *
 *
 *
 *
 * */


