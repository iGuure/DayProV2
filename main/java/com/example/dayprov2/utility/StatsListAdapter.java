package com.example.dayprov2.utility;

import com.example.dayprov2.data.Task;
import com.example.dayprov2.data.TaskStats;
import com.example.dayprov2.model.Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Guure on 2017/4/26.
 * a tool transforms task data into a stats list
 * for StatsAdapter to use
 */

public class StatsListAdapter {

    public static List<TaskStats> taskMapToList(Map<List<Integer>, Map<Integer, Task>> taskMap) {
        List<TaskStats> taskStatsList = new ArrayList<TaskStats>();

        Set<List<Integer>> keys = taskMap.keySet();
        for (List<Integer> integerList : keys) {
            int year = integerList.get(0);
            int month = integerList.get(1);
            int quantity = taskMap.get(integerList).size();
            TaskStats taskStats = new TaskStats(year, month, quantity);
            taskStatsList.add(taskStats);
        }

        return taskStatsList;
    }

}
