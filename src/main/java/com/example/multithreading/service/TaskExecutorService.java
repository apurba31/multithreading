package com.example.multithreading.service;

import org.springframework.stereotype.Service;

@Service
public
class TaskExecutorService {

    private final TaskService taskService;

    public TaskExecutorService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void executeTasks() throws InterruptedException {
        taskService.runTasks();
    }
}
