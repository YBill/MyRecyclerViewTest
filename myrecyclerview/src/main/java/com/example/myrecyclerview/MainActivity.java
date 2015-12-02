package com.example.myrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private MyRecyclerViewAdapter adapter;
    private MyWaterFallsFlowAdapter flowAdapter;
    private List<String> mDatas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        assignViews();
//        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));// 类似ListVeiw
//        mRecyclerview.setLayoutManager(new GridLayoutManager(this,4));// 类似GridView
        mRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

//        adapter = new MyRecyclerViewAdapter(this);
//        adapter.setList(mDatas);
//        mRecyclerview.setAdapter(adapter);

        flowAdapter = new MyWaterFallsFlowAdapter(this);
        flowAdapter.setList(mDatas);
        mRecyclerview.setAdapter(flowAdapter);

//        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));//一条线，用于listview
//        mRecyclerview.addItemDecoration(new DividerGridItemDecoration(this));//多条线，用于Gridview样式
    }

    private void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    private void assignViews() {
        mRecyclerview = (RecyclerView) findViewById(R.id.id_recyclerview);
    }

}