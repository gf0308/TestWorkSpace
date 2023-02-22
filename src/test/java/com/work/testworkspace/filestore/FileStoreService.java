package com.work.testworkspace.filestore;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * #[전송받은 파일을 저장소에 저장하기 기능 구현 로직]#
 * // 전달받은 MultipartFile 이 온전한지 검사 (유효성검사)
 * // 해당파일을 저장할 저장전용파일이름을 생성
 * // 저장할 저장소에 저장용파일명으로 해당파일을 실제 저장
 * // (보통 저장한후, 저장했던 파일의 원본파일이름과 저장파일이름을 담은 데이터를 리턴해줌; 이런 저런데 쓸 곳이 많음)
 * */

public class FileStoreService {

    private static String STORE_PATH = "C:/works/output_files/";   // 파일명 앞에 '/' 를 붙여줄게 아니라면, 저장경로의 맨 마지막에 '/' 를 붙여주는걸 잊어선 안된다.

    public StoreResponse storeFile(MultipartFile file) throws IOException {
        if(file.isEmpty()) {
            throw new EmptyFileException();
        }

        String originalFilename = file.getOriginalFilename();
        String storeFilename = createStoreFilename(originalFilename);

        file.transferTo(new File(getFullStorePath(storeFilename)));

        return new StoreResponse(originalFilename, storeFilename);
    }


    private static String getFullStorePath(String storeFilename) {
        return STORE_PATH + storeFilename;
    }

    private static String createStoreFilename(String originalFilename) {
        String ext = extractExtension(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private static String extractExtension(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".") + 1;
        return originalFilename.substring(pos);
    }

}



