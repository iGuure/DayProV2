package com.example.dayprov2.model;

import android.app.Activity;
import android.util.Log;
import android.widget.ListView;

import com.example.dayprov2.data.Task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Guure on 2017/4/25.
 * tasks implementation. a singleton class
 */

public class Tasks implements ITasks, Serializable {

    private static final long serialVersionUID = 1L;

    private static Tasks tasks;

    private Tasks() {}

    public static Tasks getInstance(Activity activity) {
        if (tasks == null) {
            load(activity);
            if (tasks == null) {
                tasks = new Tasks();
            }
        }
        return tasks;
    }

    private Map<List<Integer>, Map<Integer, Task>> tasksData = new HashMap<List<Integer>, Map<Integer, Task>>();

    @Override
    public void addEdit(Task task) {
        int year = task.getCalender().get(Calendar.YEAR);
        int month = task.getCalender().get(Calendar.MONTH);
        int date = task.getCalender().get(Calendar.DATE);
        List<Integer> yearMonth = new ArrayList<Integer>(Arrays.asList(year, month));
        Map<Integer, Task> specYearMonthTasks = tasksData.get(yearMonth);
        if (specYearMonthTasks == null) specYearMonthTasks = new TreeMap<Integer, Task>();
        specYearMonthTasks.put(date, task);
        tasksData.put(yearMonth, specYearMonthTasks);
    }

    @Override
    public void remove(int year, int month, int date) {
        List<Integer> yearMonth = new ArrayList<Integer>(Arrays.asList(year, month));
        Map<Integer, Task> specYearMonthTasks = tasksData.get(yearMonth);
        specYearMonthTasks.remove(date);
        if (specYearMonthTasks.size() == 0) tasksData.remove(yearMonth);
        else tasksData.put(yearMonth, specYearMonthTasks);
    }

    @Override
    public Map<List<Integer>, Map<Integer, Task>> getAllTasks() {
        return tasksData;
    }

    @Override
    public Map<Integer, Task> getSpecYearMonthTasks(int year, int month) {
        List<Integer> yearMonth = new ArrayList<Integer>(Arrays.asList(year, month));
        return tasksData.get(yearMonth);
    }

    @Override
    public Task getSpecDateTask(int year, int month, int date) {
        List<Integer> yearMonth = new ArrayList<Integer>(Arrays.asList(year, month));
        Map<Integer, Task> specYearMonthTasks = tasksData.get(yearMonth);
        return specYearMonthTasks.get(date);
    }

    public static void save(Activity activity) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = activity.openFileOutput("storage.txt", MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(tasks);
        } catch (Exception e) {
            e.printStackTrace();
            // 这里是保存文件产生异常
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    // fos流关闭异常
                    e.printStackTrace();
                }
            }
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    // oos流关闭异常
                    e.printStackTrace();
                }
            }
        }
    }

    public static void load(Activity activity) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = activity.openFileInput("storage.txt");
            ois = new ObjectInputStream(fis);
            tasks = (Tasks) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            // 这里是读取文件产生异常
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // fis流关闭异常
                    e.printStackTrace();
                }
            }
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    // ois流关闭异常
                    e.printStackTrace();
                }
            }
        }
    }
}
