package com.example.springbootdynamicquartz.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wxl
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobQueryDTO implements Serializable {
    @ApiModelProperty(value = "状态")
    private Boolean status;
    @ApiModelProperty(value = "启动时间")
    private Date beginTime;

    @ApiModelProperty(value = "任务名称")
    private String jobName;

    @ApiModelProperty(value = "当前页码")
    private Integer page = 1;


    @ApiModelProperty(value = "每页条数")
    private Integer pageSize = 10;
}
