package com.example.dayprov2.model;

import android.app.Activity;

import com.example.dayprov2.data.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by Guure on 2017/4/25.
 * what a tasks should do
 */

public interface ITasks {

    void addEdit(Task task);

    void remove(int year, int month, int date);

    Map<List<Integer>, Map<Integer, Task>> getAllTasks();

    Map<Integer, Task> getSpecYearMonthTasks(int year, int month);

    Task getSpecDateTask(int year, int month, int date);

}
