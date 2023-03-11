package com.work.fileUpload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

//@RestController

//@Controller
@ResponseBody
public class FileUploadController {

    @PostMapping("/fileUpload")
    public String fileUpload(MultipartFile file, String userName, String userPwd) {
        MultipartFile mFile = file;
        // file 정보 debug 출력
        System.out.println("==========================[file]==========================");
        System.out.println(file);
        System.out.println("==========================================================");

        String result = "";
//        String saveDestPath = "C:\\kjb\\works\\output_files\\outputfile.txt";
//        String saveDestPath = "C:\\kjb\\works\\output_files\\sample_text.txt";
        String saveDestPath = "C:\\kjb\\works\\output_files";
        String finalFullPathName = saveDestPath + File.separator + file.getOriginalFilename(); // File 오브젝트에서 getOriginalFileName() 결과인 originalFileName 자체가 '확장자' 명까지 포함한 문자열값이다.

        // file 유효성 확인 : Name, ContentType, Size 맞는지 확인
        System.out.println("file.getName: "+ file.getName());
        System.out.println("file.getContentType: "+ file.getContentType());
        System.out.println("file.getOriginalFilename: "+ file.getOriginalFilename());

        // 파일을 목표저장소에 저장
        FileOutputStream fileOutputStream;
        byte[] bytes = null;
        try {
            fileOutputStream = new FileOutputStream(finalFullPathName);
            bytes = file.getBytes();
            fileOutputStream.write(bytes);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("저장완료");


        // 저장결과에 대해 작성 후 결과 리턴

        return result;
    }

}
