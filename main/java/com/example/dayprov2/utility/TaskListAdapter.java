package com.example.dayprov2.utility;

import android.util.Log;

import com.example.dayprov2.data.Task;
import com.example.dayprov2.library.CountDays;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Guure on 2017/4/25.
 * a tool transforms task data into a task list
 * for TaskAdapter to use
 */

public class TaskListAdapter {

    public static List<Task> taskMapToList(int year, int month, Map<Integer, Task> taskMap) {
        List<Task> taskList = new ArrayList<Task>();

        int days = CountDays.count(year, month);
        for (int i = 1; i <= days; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, i);
            Task task = new Task(calendar, "");
            taskList.add(task);
        }
        if (taskMap == null)    return taskList;

        Set<Integer> keys = taskMap.keySet();
        for (Integer key : keys) {
            taskList.set(key - 1, taskMap.get(key));
        }
        return taskList;
    }

}
