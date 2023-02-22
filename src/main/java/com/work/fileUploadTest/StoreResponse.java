package com.work.fileUploadTest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter // 스프링 애플리케이션에서 어떤 요청을 받아 이를 처리한 결과를 바로 HTTP Response Body에 담아 클라이언트로 내보내주려고 할 때 (즉 API 애플리케이션), 웹컨트롤러에서 리턴해주는 Response DTO 는 반드시 Getter를 갖고 있어야 한다.
@Setter
@ToString
public class StoreResponse {
    private String originalFilename;
    private String storeFilename;

    public StoreResponse(String originalFilename, String storeFilename) {
        this.originalFilename = originalFilename;
        this.storeFilename = storeFilename;
    }

}
