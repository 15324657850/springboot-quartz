package com.example.springbootdynamicquartz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wxl
 */
@Getter
@AllArgsConstructor
public enum JobStatus {
    /**
     * 正常
     */
    NORMAL(true, "正常"),
    /**
     * 异常
     */
    ABNORMAL(false, "异常");

    private final Boolean status;
    private final String decrrption;

}
