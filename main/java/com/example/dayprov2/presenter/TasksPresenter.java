package com.example.dayprov2.presenter;

import android.app.Activity;
import android.util.Log;

import com.example.dayprov2.data.Task;
import com.example.dayprov2.library.Current;
import com.example.dayprov2.model.ITasks;
import com.example.dayprov2.model.Tasks;
import com.example.dayprov2.utility.TaskListAdapter;
import com.example.dayprov2.view.ITasksActivity;

import java.util.List;
import java.util.Map;

/**
 * Created by Guure on 2017/4/25.
 * serve for tasks module
 */

public class TasksPresenter {

    private ITasksActivity tasksActivity;
    private ITasks tasks;

    public TasksPresenter(ITasksActivity tasksActivity, Activity activity) {
        this.tasksActivity = tasksActivity;
        tasks = Tasks.getInstance(activity);
    }

    public void showSpecYearMonthTasks(int year, int month) {
        Map<Integer, Task> taskMap = tasks.getSpecYearMonthTasks(year, month);
        List<Task> taskList = TaskListAdapter.taskMapToList(year, month, taskMap);
        tasksActivity.showTasks(taskList);
    }

}
