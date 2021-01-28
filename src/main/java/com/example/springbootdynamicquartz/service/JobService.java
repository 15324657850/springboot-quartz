package com.example.springbootdynamicquartz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdynamicquartz.dto.JobQueryDTO;
import com.example.springbootdynamicquartz.entity.Job;

/**
 * @author wxl
 */
public interface JobService extends IService<Job> {

    IPage<Job> jobList(JobQueryDTO jobQueryDTO);
}
