package com.example.user.localservertest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.localservertest.adapter.LectureAdapter;
import com.example.user.localservertest.data.Lecture;
import com.example.user.localservertest.util.ServerUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private android.widget.ListView lectureListView;
    List<Lecture> lectureList = new ArrayList<>();
    LectureAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        lectureListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int lectureId = lectureList.get(position).getId();
                Intent intent = new Intent(mContext, StudentListActivity.class);
                intent.putExtra("lecture_id",lectureId);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {
        mAdapter = new LectureAdapter(mContext, lectureList);
        lectureListView.setAdapter(mAdapter);


        getLecturesFromServer();
    }

    private void getLecturesFromServer() {
        ServerUtil.test(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    boolean result = json.getBoolean("result");

                    if(result){

                        lectureList.clear();

                        JSONArray lectures = json.getJSONArray("lectures");
                        for (int i= 0 ; i < lectures.length() ; i++){
                            Lecture l = Lecture.getLectureFromJson(lectures.getJSONObject(i));
                            lectureList.add(l);
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(mContext, "강의목록을 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void bindViews() {
        this.lectureListView = (ListView) findViewById(R.id.lectureListView);

    }
}
