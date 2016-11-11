package com.geekhub.homework4;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskManagerImpl implements TaskManager {

    private Map<LocalDateTime, Task> tasks = new HashMap<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        tasks.put(date, task);
    }

    @Override
    public void remove(LocalDateTime date) {
        tasks.remove(date);
    }

    @Override
    public Set<String> getCategories() {
        return null;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        return null;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return null;
    }

    @Override
    public List<Task> getTasksForToday() {
        return null;
    }
}
