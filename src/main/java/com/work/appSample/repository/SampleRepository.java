package com.work.appSample.repository;

import com.work.appSample.model.vo.JobMstVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SampleRepository {

    List<JobMstVo> selectBatchList();

}
