package com.work.testworkspace.io.makeProgram;

import java.io.*;
import java.util.Scanner;

/**
 * #프로그램: TextFileIORunnerV2
 *
 * #프로그램 설명
 * (TextFileIORunner 의 ver.2)
 * 이 프로그램은 파일 입출력을 수행하는 프로그램이다.
 * 이 프로그램은 두개의 문자열 매개변수를 전달받는다: 첫번째는 '읽어들일 텍스트파일의 경로주소', 두번째는 '해당텍스트파일을 저장할 곳의 경로주소' 다. (모두 각각 풀 경로)
 *  ex) "C:/readFileFolder/sampleInputText.txt" , "D:/readFileFolder/sampleOutputText.txt"
 *
 * 읽어들일 파일의 경로에는 실제로 해당 폴더 및 파일이 존재한다.
 *
 * 이 대상 텍스트파일의 내용을 읽어들여서(read) 저장할 위치에 해당 파일을 실제로 저장(write) 한다.
 * 
 * #매개변수 전달 방식 : Scanner 를 사용해서 자바 표준입출력으로 각각 첫번째값, 두번째값을 전달받아 사용한다.
 *
 * # Ver.3 : FileOutputStream(경로, append 여부) 의 append 를 true 로 해서 기존 내용 덮어쓰기가 아닌, 뒤에 이어 붙이기로 설정해서 IO 를 해주는 걸로 한다.
 *
 * */

public class TextFileIORunnerV3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the full path of your input text file.\n: ");
        String inputFilePath = scanner.nextLine();
        System.out.print("Input the full path of your output text file.\n: ");
        String outputFilePath = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream(inputFilePath); // 읽기대상 파일경로에 있는 파일을 실제로 읽어들이기: FileInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); // 보조스트림도 추가해서 업그레이드한 스트림 만들기(성능향상 위해) : BufferedInputStream
        byte[] inputReadByteArr = bufferedInputStream.readAllBytes(); // 해당 파일내용을 read 하기
        bufferedInputStream.close(); // read가 완료됐으면 읽기스트림을 닫기(close)

        FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath, true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(inputReadByteArr);
        bufferedOutputStream.close();

        System.out.println("");
        System.out.println("================================");
        System.out.println("The Text File I/O has completed.");
        System.out.println("================================");
        System.out.println("");
    }
}
