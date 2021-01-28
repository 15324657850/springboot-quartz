package com.example.springbootdynamicquartz.config2;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springbootdynamicquartz.entity.Job;
import com.example.springbootdynamicquartz.mapper.JobMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class JobRunner2 implements CommandLineRunner {

    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private CronTaskRegistrar2 cronTaskRegistrar2;

    @Override
    public void run(String... args) {
        List<Job> jobs = jobMapper.selectList(Wrappers.<Job>lambdaQuery().eq(Job::getStatus, true));
        // 初始加载数据库里状态为正常的定时任务
        if (CollectionUtils.isNotEmpty(jobs)) {
            for (Job job : jobs) {
                SchedulingRunnable2 task = new SchedulingRunnable2(job.getBeanName(), job.getMethodName(), job.getMethodParams());
                cronTaskRegistrar2.addCronTask(task, job.getCronExpression());
            }

            log.info("定时任务已加载完毕...");
        }
    }
}