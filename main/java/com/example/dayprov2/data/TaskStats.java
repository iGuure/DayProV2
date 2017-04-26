package com.example.dayprov2.data;

/**
 * Created by Guure on 2017/4/26.
 * for task stats
 */

public class TaskStats {

    private int year;
    private int month;
    private int quantity;

    public TaskStats(int year, int month, int quantity) {
        this.year = year;
        this.month = month;
        this.quantity = quantity;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

}
