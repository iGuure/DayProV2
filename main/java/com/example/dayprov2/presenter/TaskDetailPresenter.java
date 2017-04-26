package com.example.dayprov2.presenter;

import android.app.Activity;
import android.util.Log;

import com.example.dayprov2.data.Task;
import com.example.dayprov2.model.ITasks;
import com.example.dayprov2.model.Tasks;
import com.example.dayprov2.view.ITaskDetailActivity;

import java.util.Calendar;

/**
 * Created by Guure on 2017/4/26.
 * serve for task detail module
 */

public class TaskDetailPresenter {

    private ITaskDetailActivity taskDetailActivity;
    private ITasks tasks;

    public TaskDetailPresenter(ITaskDetailActivity taskDetailActivity, Activity activity) {
        this.taskDetailActivity = taskDetailActivity;
        tasks = Tasks.getInstance(activity);
    }

    public void done(Activity activity) {
        Task task = taskDetailActivity.getTask();
        String content = taskDetailActivity.getEditContent();

        if (content.length() != 0) {
            task.setContent(content);
            tasks.addEdit(task);
        } else {
            if (task.getContent().length() != 0) {
                int year = task.getCalender().get(Calendar.YEAR);
                int month = task.getCalender().get(Calendar.MONTH);
                int date = task.getCalender().get(Calendar.DATE);
                tasks.remove(year, month, date);
            }
        }

        Tasks.save(activity);
        taskDetailActivity.suicide();
    }

}
