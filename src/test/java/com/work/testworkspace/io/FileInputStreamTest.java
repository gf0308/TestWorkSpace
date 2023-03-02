package com.work.testworkspace.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

public class FileInputStreamTest {
    private String commonInputPath = "C:\\works\\output_files\\inputstream_contents\\";
    private String commonOutputPath = "C:\\works\\output_files\\outputstream_contents\\";


    @Test
    void test() {
        String fileName = "123.txt";
        String targetPath = commonInputPath + fileName;
        try {
            // 1 try
            FileInputStream fis = new FileInputStream(targetPath);
            int data = 0;

            while ((data = fis.read()) != -1) {
                // FileInputStream 의 .read() 는 데이터를 한 byte 한 byte 씩 읽어 (영문자 기준 한문자 한문자 씩 읽는다; 한땀한땀 읽는다) 아스키코드형으로 가져온다; 때문에 문자를 다시 문자로 복구하려면 char 형으로 캐스팅이 필요하다. 안그러면 아스키코드형의 정수값 int 값들로 표시될 것이다.
                System.out.print((char)data);
            }

            // 2 try
            fis = new FileInputStream(targetPath);
            int remainingByteNum = fis.available();       // FileInputStream 의 .available() : 해당 스트림에 남아있는 바이트 수를 반환(바이트 수의 추정치를 반환)
            byte[] buf = new byte[remainingByteNum];

//            fis.read()



        } catch(IOException ie) {
            ie.printStackTrace();
        }

    }// test

    @DisplayName("FileInputStream의 read 메서드 3종류로 모두 파일내용 읽어들이기 테스트")
    @Test
    void test2() {
        String fileName = "123.txt";
        String targetPath = commonInputPath + fileName;
        FileInputStream fis;
//        int data = 0;
        try {
            fis = new FileInputStream(targetPath); // 파일인풋스트림 객체 생성
            byte[] storeTargetByteArr = new byte[fis.available()];        // FileInputStream 의 .available() : 해당 스트림에 남아있는 바이트 수를 반환(바이트 수의 추정치를 반환)

//            int readResultInt = fis.read();// 하나씩 읽기
//            System.out.println("readResultInt: "+(char)readResultInt);
//            fis.read(storeTargetByteArr); // 파일내용을 한번에 읽어 바이트배열에 모두 저장
//            for (byte b : storeTargetByteArr) {
//                System.out.print((char)b);
//            }
//            fis.read(storeTargetByteArr, 0, fis.available()); // 조건 커스텀해서 읽어들이기
            fis.read(storeTargetByteArr, 0, fis.available()); // fis파일내용을, (앞에서부터)len만큼 가져와서, storeTargetByteArr 바이트배열에, 인덱스0번째부터 저장해줄거다.
            for (byte b : storeTargetByteArr) {
                System.out.print((char) b);
            }

            fis.close();
        } catch(IOException ie) {
            ie.printStackTrace();
        }

    }// test2


    @DisplayName("FileInputStream 과 FileOutputStream을 이용해 파일 읽고 쓰기 테스트")
    @Test
    void testInputStreamOutputStream () {
        String fileName = "123.txt";
        String targetPath = commonInputPath + fileName;
        FileInputStream fis;
        try {
            fis = new FileInputStream(targetPath);
            byte[] bytes = new byte[fis.available()];
            // 단박에 전부 읽어들여서 bytes 배열에 넣기
                // fis.read(bytes);
            // 커스텀하게 세밀히 조절해서 선택적으로 bytes 배열에 넣어주기
            fis.read(bytes, 0 , fis.available());
//            System.out.println("bytes[]: ");
//            for (int i=0; i<bytes.length; i++) {
//                System.out.println("[" + i + "] : " + (char) bytes[i]);
//            }
//                    bytes[]:
//                    [0] : h
//                    [1] : e
//                    [2] : l
//                    [3] : l
//                    [4] : o
//                    [5] :
//                    [6] : w
//                    [7] : o
//                    [8] : r
//                    [9] : l
//                    [10] : d
//                    [11] : !
//                    [12] :
//                    [13] :
//
//                    [14] : h
//                    [15] : i
//                    [16] : !
            fis.close();

            // 123.txt 를 읽어서 내용을 얻어 넣어놓은 배열 bytes 를 다른 곳에 저장 write 해 넣기
            String outputFileName = "file123output.txt";
            String storeOutputPath = commonOutputPath + outputFileName;
            FileOutputStream fos = new FileOutputStream(storeOutputPath);
            fos.write(bytes,1,5); // bytes 내용을, 5만큼만 가져와서, 거기서 index:1 부터의 값들을 저장하도록 할 것이다.
            fos.close();

        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }


    @DisplayName("FileInputStream 과 FileOutputStream 을 각각의 보조스트림을 덧대서 만든 걸로 파일 읽고 쓰기 테스트")
    @Test
    void testBufferedInputStreamOutputStream () {
        String fileName = "bufferedStreamTestText.txt";
        String targetPath = commonInputPath + fileName;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(targetPath));
            //byte[] bytes = new byte[bis.available()];
            //bis.read(bytes, 0 , bis.available());
            byte[] allBytes = bis.readAllBytes();
            bis.close();

            String outputFileName = "bufferedStreamOutputTestText.txt";
            String storeOutputPath = commonOutputPath + outputFileName;
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(storeOutputPath));
            //bos.write(bytes, 0, bytes.length);
            bos.write(allBytes);
            bos.close();

        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }


}
