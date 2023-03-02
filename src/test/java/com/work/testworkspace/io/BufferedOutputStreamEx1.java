package com.work.testworkspace.io;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedOutputStreamEx1 {
    private String commonPath = "C:\\works\\output_files\\outputstream_contents\\";


    @Test
    void test() {
        String fileName = "123.txt";
        String storePathName = commonPath + fileName;
        try {
            FileOutputStream fos = new FileOutputStream(storePathName);
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
//            for(int i=1; i<=9; i++) {
//                bos.write(i);
//            }
            bos.write("hello world!".getBytes("UTF-8"));
            //fos.close(); // 이건 기반스트림을 닫은것
            bos.close(); // 보조스트림 닫기 (: 보조스트림을 닫으면 기반스트림도 닫힌다)

//            FileInputStream fis = new FileInputStream(storePathName);
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            int read = bis.read();


        } catch(IOException ie) {
            ie.printStackTrace();
        }

    }// test

}
