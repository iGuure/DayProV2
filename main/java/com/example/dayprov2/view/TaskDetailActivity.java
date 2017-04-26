package com.example.dayprov2.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dayprov2.R;
import com.example.dayprov2.data.Task;
import com.example.dayprov2.presenter.TaskDetailPresenter;
import com.example.dayprov2.presenter.TasksPresenter;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskDetailActivity extends AppCompatActivity implements ITaskDetailActivity {

    private TaskDetailPresenter taskDetailPresenter;
    private Task task;

    private int year;
    private int month;

    @BindView(R.id.date) TextView dateView;
    @BindView(R.id.editContent) EditText editContent;

    @OnClick(R.id.done) void done() {
        taskDetailPresenter.done(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        ButterKnife.bind(this);
        taskDetailPresenter = new TaskDetailPresenter(this, this);

        init();
    }

    void init() {
        showDate();
    }

    void showDate() {
        task = (Task) getIntent().getSerializableExtra("task");
        year = task.getCalender().get(Calendar.YEAR);
        month = task.getCalender().get(Calendar.MONTH);
        int date = task.getCalender().get(Calendar.DATE);
        String content = task.getContent();

        dateView.setText(year + " " + (month + 1) + " " + date);
        editContent.setText(content);
        editContent.setSelection(content.length());
    }

    @Override
    public String getEditContent() {
        return editContent.getText().toString().trim();
    }

    @Override
    public Task getTask() {
        return task;
    }

    @Override
    public void suicide() {
        Intent intent = new Intent();
        intent.putExtra("year", year);
        intent.putExtra("month", month);
        setResult(RESULT_OK, intent);
        finish();
    }

}
