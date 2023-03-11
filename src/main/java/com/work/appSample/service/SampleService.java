package com.work.appSample.service;

import com.work.appSample.model.vo.JobMstVo;
import com.work.appSample.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public List<JobMstVo> getBatchList() {
        log.info(this.getClass() + " => getBatchList");
        return sampleRepository.selectBatchList();
    }




}
