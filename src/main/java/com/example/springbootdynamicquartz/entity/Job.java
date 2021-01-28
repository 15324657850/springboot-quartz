package com.example.springbootdynamicquartz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wxl
 */
@ApiModel(value = "com-example-springbootdynamicquartz-entity-Job")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "job")
public class Job implements Serializable {
    /**
     * 任务id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "任务id")
    private Integer id;

    /**
     * 任务名称
     */
    @TableField(value = "job_name")
    @ApiModelProperty(value = "任务名称")
    private String jobName;

    /**
     * bean名称
     */
    @TableField(value = "bean_name")
    @ApiModelProperty(value = "bean名称")
    private String beanName;

    /**
     * 方法名称
     */
    @TableField(value = "method_name")
    @ApiModelProperty(value = "方法名称")
    private String methodName;

    /**
     * 方法参数
     */
    @TableField(value = "method_params")
    @ApiModelProperty(value = "方法参数")
    private String methodParams;

    /**
     * cron表达式
     */
    @TableField(value = "cron_expression")
    @ApiModelProperty(value = "cron表达式")
    private String cronExpression;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 状态(1正常 0暂停)
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态(1正常 0暂停)")
    private Boolean status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_JOB_NAME = "job_name";

    public static final String COL_BEAN_NAME = "bean_name";

    public static final String COL_METHOD_NAME = "method_name";

    public static final String COL_METHOD_PARAMS = "method_params";

    public static final String COL_CRON_EXPRESSION = "cron_expression";

    public static final String COL_REMARK = "remark";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}