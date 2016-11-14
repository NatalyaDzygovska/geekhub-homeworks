package com.geekhub.homework4.task1;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;

public class TaskDateComparator implements Comparator<Task> {

    private TaskManagerImpl taskManager;

    public TaskDateComparator(TaskManagerImpl taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public int compare(Task o1, Task o2) {
        LocalDateTime date1 = null, date2 = null;
        for(Map.Entry<LocalDateTime, Task> taskEntry: taskManager.getTasks().entrySet()){
            if(taskEntry.getValue().equals(o1)){
                date1 = taskEntry.getKey();
            }
            if(taskEntry.getValue().equals(o2)){
                date2 = taskEntry.getKey();
            }
        }
        return date1.compareTo(date2);

    }
}
