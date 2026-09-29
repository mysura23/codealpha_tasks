package com.codealpha.devops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for TaskManager and Task model.
 * CodeAlpha DevOps Internship - Task 3
 * Author: Mysura Reddy
 */
class TaskManagerTest {

    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = new TaskManager();
    }

    @Test
    @DisplayName("Should add task successfully with auto-incremented ID")
    void testAddTask() {
        Task t1 = manager.addTask("Configure Gradle Build", "DevOps");
        Task t2 = manager.addTask("Create Dockerfile", "Docker");

        assertEquals(1, t1.getId());
        assertEquals(2, t2.getId());
        assertEquals(2, manager.getTaskCount());
        assertEquals("Configure Gradle Build", t1.getTitle());
        assertEquals("DevOps", t1.getCategory());
        assertFalse(t1.isCompleted());
    }

    @Test
    @DisplayName("Should mark task as completed")
    void testMarkTaskAsCompleted() {
        Task t1 = manager.addTask("Write Unit Tests", "Testing");
        boolean result = manager.markTaskAsCompleted(t1.getId());

        assertTrue(result);
        assertTrue(t1.isCompleted());
    }

    @Test
    @DisplayName("Should return false when marking non-existent task ID")
    void testMarkInvalidTaskId() {
        boolean result = manager.markTaskAsCompleted(999);
        assertFalse(result);
    }

    @Test
    @DisplayName("Should separate pending and completed tasks correctly")
    void testFilterCompletedAndPendingTasks() {
        Task t1 = manager.addTask("Task 1", "DevOps");
        Task t2 = manager.addTask("Task 2", "DevOps");
        Task t3 = manager.addTask("Task 3", "DevOps");

        manager.markTaskAsCompleted(t1.getId());

        List<Task> completed = manager.getCompletedTasks();
        List<Task> pending = manager.getPendingTasks();

        assertEquals(1, completed.size());
        assertEquals(2, pending.size());
        assertEquals("Task 1", completed.get(0).getTitle());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when task title is empty")
    void testInvalidTaskTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addTask("   ", "DevOps");
        });
    }

    @Test
    @DisplayName("Should clear all tasks correctly")
    void testClearAllTasks() {
        manager.addTask("Task A", "General");
        manager.addTask("Task B", "General");
        assertEquals(2, manager.getTaskCount());

        manager.clearAllTasks();
        assertEquals(0, manager.getTaskCount());
    }
}
