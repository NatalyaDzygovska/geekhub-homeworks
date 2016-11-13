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
        Arrays.stream(categories).forEach(category -> tasksByCategories.put(category, getTasksByCategory(category)));
        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(Category category) {
        return this.tasks.values().stream()
                .filter(task -> category.equals(task.getCategory()))
                .sorted().collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksForToday() {
        LocalDate localDate = LocalDate.now();
        return tasks.entrySet().stream()
                .filter(taskEntry -> taskEntry.getKey().toLocalDate().equals(localDate))
                .map(Map.Entry::getValue)
                .sorted().collect(Collectors.toList());
    }
}
