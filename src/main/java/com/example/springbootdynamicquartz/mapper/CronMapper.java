package com.example.springbootdynamicquartz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdynamicquartz.entity.Cron;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wxl
 */
@Mapper
public interface CronMapper extends BaseMapper<Cron> {
}