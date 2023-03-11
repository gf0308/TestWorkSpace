package com.work.appSample.controller;

import com.work.appSample.model.dto.JobMstDto;
import com.work.appSample.model.vo.JobMstVo;
import com.work.appSample.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/sample")
@RequiredArgsConstructor
@RestController
public class SampleController {

    private final SampleService sampleService;


    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }

    @PostMapping("/hello2")
    public String hello2(String name) {
        return "hello2 " + name;
    }

    @PostMapping("/getBatchList")
    public List<JobMstDto.JobMstResDto> getBatchList() {
        log.info(this.getClass() + " => getBatchList");

        List<JobMstVo> batchList = sampleService.getBatchList();

        List<JobMstDto.JobMstResDto> batchResDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (JobMstVo jobMstVo : batchList) {
            batchResDtoList.add(modelMapper.map(jobMstVo, JobMstDto.JobMstResDto.class));
        }

        return batchResDtoList;
    }



}
