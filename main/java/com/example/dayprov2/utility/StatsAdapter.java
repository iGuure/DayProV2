package com.example.dayprov2.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dayprov2.R;
import com.example.dayprov2.data.Task;
import com.example.dayprov2.data.TaskStats;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Guure on 2017/4/26.
 * for listview of stats activity
 */

public class StatsAdapter  extends ArrayAdapter<TaskStats> {

    private int resourceId;

    public StatsAdapter(Context context, int textViewResourceId, List<TaskStats> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TaskStats taskStats = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        TextView taskStatsYear = (TextView) view.findViewById(R.id.statsYear);
        TextView taskStatsMonth = (TextView) view.findViewById(R.id.statsMonth);
        TextView taskStatsQuantity = (TextView) view.findViewById(R.id.statsQuantity);

        taskStatsYear.setText(taskStats.getYear() + "");
        // only add 1 when showing
        taskStatsMonth.setText((taskStats.getMonth() + 1) + "");
        taskStatsQuantity.setText("[ " + taskStats.getQuantity() + " ]");

        return view;
    }
}
