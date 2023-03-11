package com.work.appSample.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class JobMstDto {
    @Getter
    @Setter
    @ToString
    static public class JobMstReqDto {
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

    @Getter
    @Setter
    @ToString
    static public class JobMstResDto {
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

}

