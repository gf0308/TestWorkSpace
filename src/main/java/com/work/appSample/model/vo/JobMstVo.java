package com.work.appSample.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JobMstVo {
    private String rid;
    private String createBy;
    private String createDate;
    private String modifyBy;
    private String modifyDate;
    private String flag;
    private String jobName;
    private String jobDesc;
    private String status;
    private String cronExp;
    private String cronExpDesc;
    private String runResult;
    private String jobClassFullPath;
}

