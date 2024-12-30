package com.example.multithreading.service;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final java.util.concurrent.ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(3);

    public void runTasks() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " started by thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulate task processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Task " + taskId + " was interrupted.");
                }
                System.out.println("Task " + taskId + " completed by thread: " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);
        System.out.println("All tasks completed.");
    }
}
