package com.example.zohar.androiddeepbok.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zohar.androiddeepbok.R;
import com.example.zohar.androiddeepbok.widget.recyclerview.BaseWithEmptyViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainRvAdapter extends BaseWithEmptyViewAdapter<String> {
    private Context mContext;

    public MainRvAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemHolder(LayoutInflater mInflater, ViewGroup parent, int viewType) {
        return new ContentViewHolder(mInflater.inflate(R.layout.layout_item_main, parent, false));
    }

    @Override
    public RecyclerView.ViewHolder onCreateEmptyHolder(LayoutInflater mInflater, ViewGroup parent, int viewType) {
        return new EmptyViewHolder(mInflater.inflate(R.layout.layout_empty_list, parent, false));
    }

    @Override
    public void onBindItemHolder(List<String> mDataList, RecyclerView.ViewHolder holder, final int position, final OnItemClickListener onItemClickListener) {
        if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).btnItem.setText(mDataList.get(position));
            ((ContentViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }

    @Override
    public void onBindEmptyHolder(RecyclerView.ViewHolder holder) {

    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_item)
        AppCompatButton btnItem;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_empty)
        AppCompatImageView ivEmpty;
        @BindView(R.id.tv_empty)
        AppCompatTextView tvEmpty;

        EmptyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
