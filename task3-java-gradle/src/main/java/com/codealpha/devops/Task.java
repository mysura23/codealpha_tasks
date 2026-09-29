package com.codealpha.devops;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Task model class representing a DevOps task.
 * Part of CodeAlpha DevOps Internship - Task 3.
 * Author: Mysura Reddy
 */
public class Task {
    private final int id;
    private final String title;
    private final String category;
    private boolean completed;
    private final LocalDateTime createdAt;

    public Task(int id, String title, String category) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty.");
        }
        this.id = id;
        this.title = title.trim();
        this.category = category != null ? category.trim() : "General";
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createdAt.format(formatter);
    }

    @Override
    public String toString() {
        String status = completed ? "[COMPLETED]" : "[PENDING]  ";
        return String.format("%s ID: %d | Title: %-30s | Category: %-12s | Created: %s",
                status, id, title, category, getFormattedDate());
    }
}
