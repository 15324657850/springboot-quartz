
package com.example.springbootdynamicquartz.config;

import com.example.springbootdynamicquartz.entity.Cron;

public class SchedulingRunnable implements Runnable {


    private Cron cron;

    public SchedulingRunnable(Cron cron) {
        this.cron = cron;
    }

    @Override
    public void run() {
        //执行任务
        int i = 0;
        System.out.println("执行任务" + cron.getId() +(i+1));
    }
}