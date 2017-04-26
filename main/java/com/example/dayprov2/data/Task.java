package com.example.dayprov2.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Guure on 2017/4/25.
 * original data class
 */

public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private Calendar calendar;

    private String content;

    public Task(Calendar calendar, String content) {
        this.calendar = calendar;
        this.content = content;
    }

    public void setCalender(Calendar calendar) {
        this.calendar = calendar;
    }

    public Calendar getCalender() {
        return calendar;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
