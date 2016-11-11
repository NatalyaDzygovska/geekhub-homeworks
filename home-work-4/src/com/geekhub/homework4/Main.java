package com.geekhub.homework4;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManagerImpl();
        taskManager.add(LocalDateTime.of(2016, 11, 9, 10, 5), new Task("do exercise 1", Category.GEEKHUB_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 11, 11, 0), new Task("Wash clothes", Category.HOUSE_TASKS));
        taskManager.add(LocalDateTime.of(2016, 11, 11, 15, 0), new Task("Go home", Category.HOUSE_TASKS));
        taskManager.getCategories().forEach(System.out::println);
        System.out.println();
        System.out.println("Tasks for today: ");
        for (Task task : taskManager.getTasksForToday()){
            System.out.println("\t" + task.getName());
        }

    }
}
