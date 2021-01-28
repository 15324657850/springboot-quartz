package com.example.springbootdynamicquartz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wxl
 */
@ApiModel(value = "com-example-springbootdynamicquartz-entity-Cron")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cron")
public class Cron implements Serializable {
    /**
     * 表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "表主键")
    private Integer id;

    /**
     * 发送时间
     */
    @TableField(value = "send_time")
    @ApiModelProperty(value = "发送时间")
    private String sendTime;

    /**
     * 状态(0：停止使用，1：使用)
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态(0：停止使用，1：使用)")
    private Integer status;

    /**
     * 表达式
     */
    @TableField(value = "cron_str")
    @ApiModelProperty(value = "表达式")
    private String cronStr;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_SEND_TIME = "send_time";

    public static final String COL_STATUS = "status";

    public static final String COL_CRON_STR = "cron_str";
}