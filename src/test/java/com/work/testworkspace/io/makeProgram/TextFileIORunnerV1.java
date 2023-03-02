package com.work.testworkspace.io.makeProgram;

import java.io.*;

/**
 * #프로그램: TextFileIORunnerV1
 *
 * #프로그램 설명
 * 이 프로그램은 파일 입출력을 수행하는 프로그램이다.
 * 이 프로그램은 두개의 문자열 매개변수를 전달받는다: 첫번째는 '읽어들일 텍스트파일의 경로주소', 두번째는 '해당텍스트파일을 저장할 곳의 경로주소' 다. (모두 각각 풀 경로)
 *  ex) "C:/readFileFolder/sampleInputText.txt" , "D:/readFileFolder/sampleOutputText.txt"
 * 파라미터는 메인메소드의 파라미터로 전달받는다.
 *
 * 읽어들일 파일의 경로에는 실제로 해당 폴더 및 파일이 존재한다.
 *
 * 이 대상 텍스트파일의 내용을 읽어들여서(read) 저장할 위치에 해당 파일을 실제로 저장(write) 한다.
 * 
 * #매개변수 전달 방식 : cmd창에서 java 프로그램 실행할 때 직접 첫번째인자, 두번째인자를 입력해서 같이 실행해주는 방식
 *
 * */

public class TextFileIORunnerV1 {
    public static void main(String[] args) throws IOException {
        String inputFilePath = args[0];      // "C:/sampleInputText.txt"
        String outputFilePath = args[1];    // "D:/sampleOutputText.txt"

        FileInputStream fileInputStream = new FileInputStream(inputFilePath); // 읽기대상 파일경로에 있는 파일을 실제로 읽어들이기: FileInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); // 보조스트림도 추가해서 업그레이드한 스트림 만들기(성능향상 위해) : BufferedInputStream
        byte[] inputReadByteArr = bufferedInputStream.readAllBytes(); // 해당 파일내용을 read 하기
        bufferedInputStream.close(); // read가 완료됐으면 읽기스트림을 닫기(close)

        FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath); // 쓰기대상 파일경로에 파일을 저장할 수 있는 아웃풋스트림 만들기 : FileOutputStream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream); // 보조스트림 추가해서 업그레이드한 스트림 만들기 : BufferedOutputStream
        bufferedOutputStream.write(inputReadByteArr); // read 해온 파일내용을 쓰기대상 파일경로에 실제로 저장(write)해 써넣기
        bufferedOutputStream.close(); // write가 완료됐으면 쓰기스트림을 닫기(close)

        System.out.println("The Text File I/O has completed.");
    }
}
