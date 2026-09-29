package com.codealpha.devops;

import java.util.List;

/**
 * Main application entry point for DevOps Task Tracker.
 * Part of CodeAlpha DevOps Internship - Task 3.
 * Author: Mysura Reddy
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   CodeAlpha DevOps Internship - Task 3");
        System.out.println("   DevOps Task Tracker (Java + Gradle)");
        System.out.println("   Author: Mysura Reddy");
        System.out.println("==================================================\n");

        TaskManager manager = new TaskManager();

        System.out.println("[+] Initializing default DevOps tasks...");
        manager.addTask("Set up Gradle build automation", "Build");
        manager.addTask("Write JUnit unit tests for TaskManager", "Testing");
        manager.addTask("Configure GitHub Actions CI/CD Pipeline", "CI/CD");
        manager.addTask("Deploy web server using Docker container", "Docker");

        System.out.println("\n[+] Listing all tasks:");
        printTasks(manager.getAllTasks());

        System.out.println("\n[+] Marking Task #1 & Task #2 as Completed...");
        manager.markTaskAsCompleted(1);
        manager.markTaskAsCompleted(2);

        System.out.println("\n[+] Updated Task List:");
        printTasks(manager.getAllTasks());

        System.out.println("\n[+] Summary Metrics:");
        System.out.println("    Total Tasks     : " + manager.getTaskCount());
        System.out.println("    Completed Tasks : " + manager.getCompletedTasks().size());
        System.out.println("    Pending Tasks   : " + manager.getPendingTasks().size());

        System.out.println("\n==================================================");
        System.out.println("   DevOps Task Tracker Executed Successfully!");
        System.out.println("==================================================");
    }

    private static void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("    No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println("    " + task);
        }
    }
}
