package com.wx.project.wxApp.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask1 {
    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  "+(count++));
    }
}
