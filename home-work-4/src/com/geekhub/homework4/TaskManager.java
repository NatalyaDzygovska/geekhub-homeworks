package com.geekhub.homework4;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TaskManager {

    void add(LocalDateTime date, Task task);

    void remove(LocalDateTime date);

    Set<Category> getCategories();

    //For next 3 methods tasks should be sorted by date
    Map<Category, List<Task>> getTasksByCategories(Category ... categories);

    List<Task> getTasksByCategory(Category category);

    List<Task> getTasksForToday();
}
