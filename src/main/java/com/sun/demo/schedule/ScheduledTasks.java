package com.sun.demo.schedule;

/**
 * Created by kimi on 5/3/16.
 */

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //@Scheduled(cron = "*/3 * * * * *")
    @Scheduled(fixedRate = 60000)
    public void show() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
