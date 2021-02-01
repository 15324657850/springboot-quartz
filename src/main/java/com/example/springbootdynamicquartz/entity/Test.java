package com.example.springbootdynamicquartz.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="com-example-springbootdynamicquartz-entity-Test")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test")
public class Test implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="id")
    private Integer id;

    /**
     * 名字
     */
    @TableField(value = "name")
    @ApiModelProperty(value="名字")
    private String name;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill= FieldFill.INSERT)
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time",fill= FieldFill.UPDATE)
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}