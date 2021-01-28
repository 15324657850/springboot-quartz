package com.example.springbootdynamicquartz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdynamicquartz.dto.JobQueryDTO;
import com.example.springbootdynamicquartz.entity.Job;
import com.example.springbootdynamicquartz.mapper.JobMapper;
import com.example.springbootdynamicquartz.service.JobService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author wxl
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

    @Override
    public IPage<Job> jobList(JobQueryDTO jobQueryDTO) {
        LambdaQueryWrapper<Job> lambdaQuery = Wrappers.<Job>lambdaQuery();

        if (StringUtils.isNotEmpty(jobQueryDTO.getJobName())) {
            lambdaQuery.like(Job::getJobName, jobQueryDTO.getJobName());
        }

        if (jobQueryDTO.getStatus() != null) {
            lambdaQuery.eq(Job::getStatus, jobQueryDTO.getStatus());
        }
        if (jobQueryDTO.getBeginTime() != null) {
            lambdaQuery.ge(Job::getCreateTime, jobQueryDTO.getBeginTime());

        }

        lambdaQuery.orderByDesc(Job::getCreateTime);
        Page<Job> page = page(new Page<>(jobQueryDTO.getPage(), jobQueryDTO.getPageSize()), lambdaQuery);

        return page;
    }
}
