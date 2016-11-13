package com.geekhub.homework4.task1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManagerImpl();
        taskManager.add(LocalDateTime.of(2016, 11, 9, 10, 5), new Task("do exercise 1", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 11, 11, 0), new Task("Wash clothes", Category.HOUSE_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 11, 15, 0), new Task("Go home", Category.HOUSE_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 9, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 15, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 10, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 16, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 11, 0), new Task("do home work", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 12, 17, 0), new Task("do home work", Category.GEEKHUB_TASKS));

        printCategories(taskManager);

        printTasksForToday(taskManager);

        printTasksByCategories(taskManager);

    }

    private static void printTasksByCategories(TaskManager taskManager) {
        for(Map.Entry<Category, List<Task>>  tasks: taskManager.getTasksByCategories(Category.values()).entrySet()){
            System.out.println(tasks.getKey());
            for(Task task : tasks.getValue()){
                System.out.println(task.getDate());
            }
        }
    }

    private static void printTasksForToday(TaskManager taskManager) {
        System.out.println("Tasks for today: ");
        for (Task task : taskManager.getTasksForToday()){
            System.out.println("\t" + task.getDate());
        }
    }

    private static void printCategories(TaskManager taskManager) {
        taskManager.getCategories().forEach(System.out::println);
    }
}
