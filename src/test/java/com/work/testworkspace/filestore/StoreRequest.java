package com.work.testworkspace.filestore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class StoreRequest {
    private String name;
    private String job;
    private int age;
    private MultipartFile file;
}

