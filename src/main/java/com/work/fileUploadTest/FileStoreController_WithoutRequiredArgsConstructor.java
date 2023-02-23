package com.work.fileUploadTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


//@RestController // 이 클래스는 빈 등록되면 안되니까 @Component 부분은 꺼둠
@Slf4j
public class FileStoreController_WithoutRequiredArgsConstructor {

    private final FileStoreService fileStoreService;
    private final SecondFileStoreService secondFileStoreService;

    //@Autowired // 이 처럼 클래스의 생성자가(명시적으로 작성된 생성자가) 하나이면 생성자에 @Autowired 애노테이션은 생략가능하다. (스프링이 생성자주입 방식을 적극 지원하고 있기에 지원하고 있는 것)
    public FileStoreController_WithoutRequiredArgsConstructor(FileStoreService fileStoreService, SecondFileStoreService secondFileStoreService) {
        this.fileStoreService = fileStoreService;
        this.secondFileStoreService = secondFileStoreService;
    }
    // 생성자주입 상황에서 만약 명시적으로 작성해놓은 생성자가 두개 이상일 경우에, @Autowired 은 오직 한 개의 생성자에만 붙여줄 수 있다; 그게 default constructor 가 된다.
    // 그리고 이 상황에서 디폴트 생성자로 삼을 곳에 @Autowired 를 붙여주지 않은 상태로 실행시키면, 'Bean Instantiation 에러'가 발생한다. (디폴트 생성자가 없다고 스프링이 인식하기 때문에, 빈 생성을 못하고 에러를 발생시킴)


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return fileStoreService.sayHello();
    }

    @GetMapping("/saySecondHello")
    public String saySecondHello() {
        return secondFileStoreService.saySecondHello();
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
