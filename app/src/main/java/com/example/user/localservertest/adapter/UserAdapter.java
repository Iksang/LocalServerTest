package com.example.user.localservertest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.localservertest.R;
import com.example.user.localservertest.data.User;

import java.util.List;

/**
 * Created by tjoeun on 2017-11-17.
 */

public class UserAdapter  extends ArrayAdapter<User> {

    Context mContext;
    List<User> mList;
    LayoutInflater inf;

    public UserAdapter (Context context, List<User> list){
        super(context, R.layout.lecture_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.lecture_list_item, null);
        }

        User data = mList.get(position);

//        TextView lectureNameTxt = row.findViewById(R.id.lectureNameTxt);
//        TextView openTimeTxt = row.findViewById(R.id.openTimeTxt);
//        TextView closeTimeTxt = row.findViewById(R.id.closeTimeTxt);
//        TextView startDateTxt = row.findViewById(R.id.startDateTxt);
//        TextView endDateTxt  = row.findViewById(R.id.endDateTxt);
//
//        lectureNameTxt.setText(data.getName());
//        openTimeTxt.setText(data.getOpen_time());
//        closeTimeTxt.setText(data.getClose_time());
//        startDateTxt.setText(data.getStart_date());
//        endDateTxt.setText(data.getEnd_date());



        return row;
    }

}