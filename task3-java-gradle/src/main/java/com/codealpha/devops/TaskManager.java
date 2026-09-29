package com.codealpha.devops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * TaskManager handles business logic for adding, completing, and querying tasks.
 * Part of CodeAlpha DevOps Internship - Task 3.
 * Author: Mysura Reddy
 */
public class TaskManager {
    private final List<Task> tasks;
    private int nextId;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Adds a new task with specified title and category.
     */
    public Task addTask(String title, String category) {
        Task task = new Task(nextId++, title, category);
        tasks.add(task);
        return task;
    }

    /**
     * Adds a new task with default category 'General'.
     */
    public Task addTask(String title) {
        return addTask(title, "General");
    }

    /**
     * Returns an unmodifiable list of all tasks.
     */
    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(tasks);
    }

    /**
     * Finds task by ID.
     */
    public Optional<Task> getTaskById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    /**
     * Marks a task as completed given its ID.
     */
    public boolean markTaskAsCompleted(int id) {
        Optional<Task> taskOpt = getTaskById(id);
        if (taskOpt.isPresent()) {
            taskOpt.get().markCompleted();
            return true;
        }
        return false;
    }

    /**
     * Filters completed tasks.
     */
    public List<Task> getCompletedTasks() {
        return tasks.stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }

    /**
     * Filters pending tasks.
     */
    public List<Task> getPendingTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    /**
     * Gets total task count.
     */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Clears all tasks from the manager.
     */
    public void clearAllTasks() {
        tasks.clear();
        nextId = 1;
    }
}
