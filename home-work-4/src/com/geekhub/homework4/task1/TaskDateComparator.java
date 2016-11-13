package com.geekhub.homework4.task1;

import java.util.Comparator;

public class TaskDateComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        return task1.getDate().compareTo(task2.getDate());
    }

}
