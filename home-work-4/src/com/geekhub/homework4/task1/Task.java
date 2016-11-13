package com.geekhub.homework4.task1;

import java.time.LocalDateTime;

public class Task implements Comparable {
    private String name;
    private Category category;
    private LocalDateTime date;

    public Task(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public int compareTo(Object o) {
        return this.date.compareTo(((Task) o).getDate());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
