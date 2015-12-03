package com.example.myrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ClickListener{

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
        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerview.setLayoutManager(manager);// 类似ListVeiw
//        mRecyclerview.setLayoutManager(new GridLayoutManager(this,4));// 类似GridView
//        mRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));

        //正常的
        adapter = new MyRecyclerViewAdapter(this);
        adapter.setList(mDatas);
        mRecyclerview.setAdapter(adapter);
        adapter.setmCallback(this);

        //瀑布流
//        flowAdapter = new MyWaterFallsFlowAdapter(this);
//        flowAdapter.setList(mDatas);
//        mRecyclerview.setAdapter(flowAdapter);
//        flowAdapter.setOnItemClickListener(new MyWaterFallsFlowAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this, "click:"+mDatas.get(position), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//                Toast.makeText(MainActivity.this, "long click:"+mDatas.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });

//        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));//一条线，用于listview
        mRecyclerview.addItemDecoration(new DividerGridItemDecoration(this));//多条线，用于Gridview样式
    }

    private void initData() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    private void assignViews() {
        mRecyclerview = (RecyclerView) findViewById(R.id.id_recyclerview);
    }

    @Override
    public void onClick(int index) {
        Toast.makeText(MainActivity.this, "click:"+mDatas.get(index), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(int index) {
        Toast.makeText(MainActivity.this, "long click:"+mDatas.get(index), Toast.LENGTH_SHORT).show();
    }
}