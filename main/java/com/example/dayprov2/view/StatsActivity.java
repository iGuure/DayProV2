package com.example.dayprov2.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dayprov2.R;
import com.example.dayprov2.data.TaskStats;
import com.example.dayprov2.presenter.StatsPresenter;
import com.example.dayprov2.utility.StatsAdapter;
import com.example.dayprov2.utility.TaskAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatsActivity extends AppCompatActivity implements IStatsActivity {

    @BindView(R.id.stats) ListView stats;

    private StatsPresenter statsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        ButterKnife.bind(this);
        statsPresenter = new StatsPresenter(this, this);

        init();
    }

    void init() {
        statsPresenter.show();
    }

    @Override
    public void showStats(List<TaskStats> taskStatsList) {
        StatsAdapter statsAdapter = (taskStatsList == null ? null : new StatsAdapter(StatsActivity.this, R.layout.stats_item, taskStatsList));
        stats.setAdapter(statsAdapter);
    }
}
