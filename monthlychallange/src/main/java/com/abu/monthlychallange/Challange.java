package com.abu.monthlychallange;

public class Challange {
    private Long id;
    private String month;
    private String task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Challange(Long id, String month, String task) {
        this.id = id;
        this.month = month;
        this.task = task;
    }

}
