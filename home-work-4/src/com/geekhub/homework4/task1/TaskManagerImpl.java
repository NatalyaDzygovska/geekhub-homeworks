package com.geekhub.homework4.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManagerImpl implements TaskManager {

    private Map<LocalDateTime, Task> tasks = new HashMap<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        task.setDate(date);
        tasks.put(date, task);
    }

    @Override
    public Task remove(LocalDateTime date) {
        return tasks.remove(date);
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
        List<Task> tasks = this.tasks.values().stream()
                .filter(task -> category.equals(task.getCategory())).collect(Collectors.toList());
        Collections.sort(tasks, new TaskDateComparator());
        return tasks;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasks = this.tasks.keySet().stream()
                .filter(date -> date.toLocalDate().equals(LocalDate.now()))
                .map(date -> this.tasks.get(date)).collect(Collectors.toList());
        Collections.sort(tasks, new TaskDateComparator());
        return tasks;
    }
}
