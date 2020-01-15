package com.xkcoding.async.controller;

import com.xkcoding.async.task.TaskFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gao Jia
 * @create 20/1/15 10:40
 * @Description
 **/
@RestController
@Slf4j
public class AsyncController {
    @Autowired
    private TaskFactory taskFactory;

    /**
     * 执行无返回值的异步任务，主线程先返回，异步任务后台继续执行
     *
     * @return
     */
    @GetMapping("testasyncwithvoid")
    public String testAsyncWithVoid() {
        try {
            taskFactory.asyncTask4();
            return "后台处理中";
        } catch (InterruptedException e) {
            log.error("{}", e);
            return "Error";
        }
    }

    /**
     * 执行无返回值带参的异步任务
     *
     * @param taskName
     * @return
     */
    @GetMapping("testasyncwithparam")
    public String testAsyncWithParam(@RequestParam("taskName") String taskName) {
        try {
            taskFactory.asyncTask5(taskName);
            return "后台处理中";
        } catch (InterruptedException e) {
            log.error("{}", e);
            return "Error";
        }
    }

    /**
     * 执行无返回值带参的异步任务
     *
     * @return
     */
    @GetMapping("testasyncwithotherexecutor")
    public String testAsyncWithOtherExecutor() {
        try {
            taskFactory.asyncTask6();
            return "后台处理中";
        } catch (InterruptedException e) {
            log.error("{}", e);
            return "Error";
        }
    }
}
