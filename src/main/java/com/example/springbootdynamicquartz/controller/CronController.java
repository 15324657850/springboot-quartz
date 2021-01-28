package com.example.springbootdynamicquartz.controller;


import com.example.springbootdynamicquartz.config.CronTaskRegistrar;
import com.example.springbootdynamicquartz.config.SchedulingRunnable;
import com.example.springbootdynamicquartz.entity.Cron;
import com.example.springbootdynamicquartz.service.CronService;
import com.example.springbootdynamicquartz.util.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author wxl
 */
@RestController
public class CronController {

    @Autowired
    private CronService cronService;

    @Autowired
    private CronTaskRegistrar taskRegistrar;


    @PostMapping("/saveCron")
    public HttpResult save() {
        Cron cron = new Cron();
        //每天八点一十五分
        cron.setCronStr("0/2 * * * * ?");
        cron.setStatus(1);
        cron.setSendTime("08:15");
        boolean success = cronService.saveOrUpdate(cron);
        if (!success) {
            return HttpResult.error("定时任务保存失败");
        }
        if (cron.getStatus() == 1) {
            SchedulingRunnable task = new SchedulingRunnable(cron);
            taskRegistrar.removeCronTask(cron.getId());
            taskRegistrar.addCronTask(cron.getId(), task, cron.getCronStr());
        }
        if (cron.getStatus() == 0) {
            taskRegistrar.removeCronTask(cron.getId());
        }
        return HttpResult.ok("定时任务保存成功");
    }

    @PostMapping("/deleteCron")
    public HttpResult delete(Integer cronId) {
        if (cronId != null) {
            Cron cron = cronService.getById(cronId);
            cron.setStatus(0);
            boolean remove = cronService.updateById(cron);
            if (remove) {
                taskRegistrar.removeCronTask(cronId);
            }
            return HttpResult.ok("定时任务删除成功");
        }
        return HttpResult.error("传入数据为空");
    }

    public List<Cron> findCrons() {
        return cronService.list();
    }


}
