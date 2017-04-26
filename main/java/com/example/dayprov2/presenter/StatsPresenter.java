package com.example.dayprov2.presenter;

import android.app.Activity;

import com.example.dayprov2.data.Task;
import com.example.dayprov2.data.TaskStats;
import com.example.dayprov2.model.ITasks;
import com.example.dayprov2.model.Tasks;
import com.example.dayprov2.utility.StatsListAdapter;
import com.example.dayprov2.view.IStatsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guure on 2017/4/26.
 * serve for stats module
 */

public class StatsPresenter {

    private IStatsActivity statsActivity;
    private ITasks tasks;

    public StatsPresenter(IStatsActivity statsActivity, Activity activity) {
        this.statsActivity = statsActivity;
        tasks = Tasks.getInstance(activity);
    }

    public void show() {
        List<TaskStats> taskStatsList = StatsListAdapter.taskMapToList(tasks.getAllTasks());
        statsActivity.showStats(taskStatsList);
    }

}
