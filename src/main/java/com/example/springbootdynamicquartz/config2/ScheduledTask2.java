package com.example.springbootdynamicquartz.config2;

import java.util.concurrent.ScheduledFuture;

public final class ScheduledTask2 {

    volatile ScheduledFuture<?> future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        ScheduledFuture<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }
}