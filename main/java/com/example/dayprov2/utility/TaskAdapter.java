package com.example.dayprov2.utility;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dayprov2.R;
import com.example.dayprov2.data.Task;
import com.example.dayprov2.library.Day;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Guure on 2017/4/25.
 * for listview of task activity
 */

public class TaskAdapter extends ArrayAdapter<Task> {

    private int resourceId;

    public TaskAdapter(Context context, int textViewResourceId, List<Task> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Task task = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        TextView taskYear = (TextView) view.findViewById(R.id.year);
        TextView taskMonth = (TextView) view.findViewById(R.id.month);
        TextView taskDate = (TextView) view.findViewById(R.id.date);
        TextView taskContent = (TextView) view.findViewById(R.id.content);

        taskYear.setText(task.getCalender().get(Calendar.YEAR) + "");
        // only add 1 when showing
        taskMonth.setText((task.getCalender().get(Calendar.MONTH) + 1) + "");
        taskDate.setText(task.getCalender().get(Calendar.DATE) + "");
        taskContent.setText(task.getContent());

        // specify Sundays
        if (Day.whatDay(task.getCalender()) == 7) {
            taskYear.setTextColor(Color.MAGENTA);
            taskMonth.setTextColor(Color.MAGENTA);
            taskDate.setTextColor(Color.MAGENTA);
        }
        return view;
    }
}
