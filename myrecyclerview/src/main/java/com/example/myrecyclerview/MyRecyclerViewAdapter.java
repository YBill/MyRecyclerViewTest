package com.example.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 卫彪 on 2015/12/2.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>
        implements View.OnClickListener, View.OnLongClickListener{
    private List<String> list = new ArrayList<String>();
    private LayoutInflater inflater;

    public void setList(List<String> list) {
        this.list = list;
    }

    public MyRecyclerViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void onClick(View v) {
        if(v.getTag() != null){
            int index = (int)v.getTag();
            if(mCallback != null){
                mCallback.onClick(index);
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getTag() != null){
            int index = (int)v.getTag();
            if(mCallback != null){
                mCallback.onLongClick(index);
            }
            return true;
        }
        return false;
    }

    public interface ClickListener{
        void onClick(int index);
        void onLongClick(int index);
    }
    private ClickListener mCallback;

    public void setmCallback(ClickListener mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnLongClickListener(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_num);
        }
    }

}
