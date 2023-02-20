package com.work.fileUpload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//@RestController

@Controller
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
        String saveDestPath = "C:\\kjb\\works\\output_files";

        // file 유효성 확인 : Name, ContentType, Size 맞는지 확인

        // 파일을 목표저장소에 저장

        // 저장결과에 대해 작성 후 결과 리턴

        return result;
    }

}
