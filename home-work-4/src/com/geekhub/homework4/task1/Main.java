package com.geekhub.homework4.task1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TaskManagerImpl taskManager = new TaskManagerImpl();
        taskManager.add(LocalDateTime.of(2016, 11, 9, 10, 5), new Task("do exercise 1", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 11, 11, 0), new Task("Wash clothes", Category.HOUSE_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 11, 15, 0), new Task("Go home", Category.HOUSE_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 9, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 15, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 10, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 17, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 15, 9, 0), new Task("do home work", Category.UNIVERSITY_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 15, 10, 0), new Task("do home work", Category.UNIVERSITY_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 15, 12, 0), new Task("do home work", Category.UNIVERSITY_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 15, 14, 0), new Task("do home work", Category.UNIVERSITY_TASKS));

        printCategories(taskManager);

        printTasksForToday(taskManager);

        printTasksByCategories(taskManager);

    }

    private static void printTasksByCategories(TaskManagerImpl taskManager) {
        for (Map.Entry<Category, List<Task>> tasks : taskManager.getTasksByCategories(Category.values()).entrySet()) {
            System.out.println(tasks.getKey());
            for (Task task : tasks.getValue()) {
                printTaskDateTime(taskManager, task);
            }
        }
    }

    private static void printTasksForToday(TaskManagerImpl taskManager) {
        System.out.println("Tasks for today: ");
        for (Task task : taskManager.getTasksForToday()) {
            printTaskDateTime(taskManager, task);
        }
    }

    private static void printTaskDateTime(TaskManagerImpl taskManager, Task task) {
        for(Map.Entry<LocalDateTime, Task> taskEntry : taskManager.getTasks().entrySet()){
            if(task.equals(taskEntry.getValue())){
                System.out.println(taskEntry.getKey());
            }
        }
    }

    private static void printCategories(TaskManager taskManager) {
        taskManager.getCategories().forEach(System.out::println);
    }
}
