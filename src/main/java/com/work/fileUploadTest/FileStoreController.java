package com.work.fileUploadTest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@Slf4j
@RequiredArgsConstructor
public class FileStoreController {

    private final FileStoreService fileStoreService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/storeFile")
    public StoreResponse storeFile(@ModelAttribute StoreRequest request) throws IOException {
        log.info("==========================[Controller]==========================");
        log.info(getClass().getName());

        MultipartFile attachFile = request.getAttachFile();
        StoreResponse storeResponse = fileStoreService.storeFile(attachFile);

        return storeResponse;
    }

}
