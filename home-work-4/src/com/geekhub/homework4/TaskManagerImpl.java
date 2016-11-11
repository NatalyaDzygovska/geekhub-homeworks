package com.geekhub.homework4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
    public Set<Category> getCategories() {
        Set<Category> categories = new HashSet<>();
        Collections.addAll(categories, Category.values());
        return categories;
    }

    @Override
    public Map<Category, List<Task>> getTasksByCategories(Category... categories) {
        Map<Category, List<Task>> tasksByCategories = new HashMap<>();
        for (Category category : categories) {
            List<Task> tasks = getTasksByCategory(category);
            tasksByCategories.put(category, tasks);
        }
        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(Category category) {
        return this.tasks.values().stream()
                .filter(task -> category.equals(task.getCategory())).collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksForToday() {
        return this.tasks.keySet().stream()
                .filter(date -> date.toLocalDate().equals(LocalDate.now()))
                .map(date -> this.tasks.get(date)).collect(Collectors.toList());
    }
}
