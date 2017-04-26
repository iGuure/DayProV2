package com.example.dayprov2.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dayprov2.R;
import com.example.dayprov2.data.Task;
import com.example.dayprov2.library.Current;
import com.example.dayprov2.library.Month;
import com.example.dayprov2.model.Tasks;
import com.example.dayprov2.utility.TaskAdapter;
import com.example.dayprov2.presenter.TasksPresenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TasksActivity extends AppCompatActivity implements ITasksActivity {

    private static final long serialVersionUID = 1L;

    private TasksPresenter tasksPresenter;

    private ArrayAdapter<String> arrayAdapter;
    private List<String> dataList;

    private int selectedYear;
    private int selectedMonth;

    @BindView(R.id.yearSelector) Spinner yearSelector;
    @BindView(R.id.monthSelector) Spinner monthSelector;
    @BindView(R.id.content) ListView content;

    @OnClick(R.id.goToStats) void goToStats() {
        Intent intent = new Intent(TasksActivity.this, StatsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ButterKnife.bind(this);
        tasksPresenter = new TasksPresenter(this, this);
        init();

        // set Spinner listeners
        yearSelector.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear = Current.year - position;
                tasksPresenter.showSpecYearMonthTasks(selectedYear, selectedMonth);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        monthSelector.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMonth = position;
                tasksPresenter.showSpecYearMonthTasks(selectedYear, selectedMonth);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    void init() {
        initSpinner();
        tasksPresenter.showSpecYearMonthTasks(selectedYear, selectedMonth);
    }

    void initSpinner() {
        // load data into spinner
        dataList = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            dataList.add(Current.year - i + "");
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSelector.setAdapter(arrayAdapter);

        dataList = Month.getMonthList();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSelector.setAdapter(arrayAdapter);

        // set default selection
        yearSelector.setSelection(0);
        monthSelector.setSelection(Current.month);

        // set variables
        selectedYear = Current.year;
        selectedMonth = Current.month;
    }

    @Override
    public void showTasks(final List<Task> taskList) {
        TaskAdapter taskAdapter = (taskList == null ? null : new TaskAdapter(TasksActivity.this, R.layout.task_item, taskList));
        content.setAdapter(taskAdapter);
        content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = taskList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("task", task);

                Intent intent = new Intent(TasksActivity.this, TaskDetailActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    int returnYear = data.getIntExtra("year", 1);
                    int returnMonth = data.getIntExtra("month", 1);
                    tasksPresenter.showSpecYearMonthTasks(returnYear, returnMonth);
                    break;
                }
            default:
                break;
        }
    }

}
