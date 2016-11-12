package com.geekhub.homework4;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TaskManager {

    void add(LocalDateTime date, Task task);

    Task remove(LocalDateTime date);

    Set<Category> getCategories();

    Map<Category, List<Task>> getTasksByCategories(Category ... categories);

    List<Task> getTasksByCategory(Category category);

    List<Task> getTasksForToday();
}
