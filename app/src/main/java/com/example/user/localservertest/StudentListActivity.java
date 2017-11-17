package com.example.user.localservertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StudentListActivity extends BaseActivity {

    int lectureId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        lectureId = getIntent().getIntExtra("lecture_id", -1);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {


    }

    @Override
    public void bindViews() {

    }
}
