package com.example.springbootdynamicquartz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springbootdynamicquartz.config2.CronTaskRegistrar2;
import com.example.springbootdynamicquartz.config2.SchedulingRunnable2;
import com.example.springbootdynamicquartz.dto.JobQueryDTO;
import com.example.springbootdynamicquartz.entity.Job;
import com.example.springbootdynamicquartz.enums.JobStatus;
import com.example.springbootdynamicquartz.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author wxl
 */
@RestController
@Slf4j
@Api(tags = "定时任务添加")
public class CronController2 {
    @Autowired
    private JobService jobService;

    @Autowired
    private CronTaskRegistrar2 cronTaskRegistrar2;

    @PostMapping
    @ApiOperation(value = "添加定时任务")
    public void save(@RequestBody Job job) {
        boolean b = jobService.saveOrUpdate(job);
        if (!b) {
            log.info("添加定时任务失败");
            return;
        }
        if (job.getStatus().equals(JobStatus.NORMAL.getStatus())) {
            SchedulingRunnable2 schedulingRunnable2 = new SchedulingRunnable2(job.getBeanName(), job.getMethodName(), job.getMethodParams());
            cronTaskRegistrar2.addCronTask(schedulingRunnable2, job.getCronExpression());
        }

        log.info("添加定时任务成功");

    }

    @PutMapping
    @ApiOperation(value = "修改定时任务")
    public void update(@RequestBody Job job) {
        boolean b = jobService.updateById(job);
        if (!b) {
            log.info("修改定时任务失败");
            return;
        }
        if (job.getStatus().equals(JobStatus.NORMAL.getStatus())) {
            SchedulingRunnable2 schedulingRunnable2 = new SchedulingRunnable2(job.getBeanName(), job.getMethodName(), job.getMethodParams());
            cronTaskRegistrar2.removeCronTask(schedulingRunnable2);
        }

        if (job.getStatus().equals(JobStatus.NORMAL.getStatus())) {
            SchedulingRunnable2 schedulingRunnable2 = new SchedulingRunnable2(job.getBeanName(), job.getMethodName(), job.getMethodParams());
            cronTaskRegistrar2.addCronTask(schedulingRunnable2, job.getCronExpression());
        }

        log.info("修改定时任务成功");

    }

    @DeleteMapping
    @ApiOperation(value = "删除定时任务")
    public void delete(@RequestParam int id) {
        Job job = jobService.getById(id);
        if (ObjectUtils.isEmpty(job)) {
            log.info("没有当前定时任务");
            return;
        }
        boolean b = jobService.removeById(id);
        if (!b) {
            log.info("删除定时任务失败");
            return;
        }
        if (job.getStatus().equals(JobStatus.NORMAL.getStatus())) {
            SchedulingRunnable2 schedulingRunnable2 = new SchedulingRunnable2(job.getBeanName(), job.getMethodName(), job.getMethodParams());
            cronTaskRegistrar2.removeCronTask(schedulingRunnable2);
        }
        log.info("删除定时任务成功");

    }

    @GetMapping
    @ApiOperation(value = "启动或者停止定时任务")
    public void change(@ModelAttribute Job job) {
        if (job.getStatus().equals(JobStatus.NORMAL.getStatus())) {
            SchedulingRunnable2 schedulingRunnable2 = new SchedulingRunnable2(job.getBeanName(), job.getMethodName(), job.getMethodParams());
            cronTaskRegistrar2.addCronTask(schedulingRunnable2, job.getCronExpression());
        } else {
            SchedulingRunnable2 task = new SchedulingRunnable2(job.getBeanName(), job.getMethodName(), job.getMethodParams());
            cronTaskRegistrar2.removeCronTask(task);
        }
    }


    @GetMapping("/list")
    @ApiOperation(value = "查询所有的定时任务")
    public IPage<Job> list(@ModelAttribute JobQueryDTO jobQueryDTO) {
        return jobService.jobList(jobQueryDTO);
    }


}
