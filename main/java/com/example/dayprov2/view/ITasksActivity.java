package com.example.dayprov2.view;

import com.example.dayprov2.data.Task;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Guure on 2017/4/25.
 */

public interface ITasksActivity extends Serializable {

    void showTasks(List<Task> taskList);

}
