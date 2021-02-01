package com.example.springbootdynamicquartz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdynamicquartz.entity.Test;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wxl
 */ 
@Mapper
public interface TestMapper extends BaseMapper<Test> {
}