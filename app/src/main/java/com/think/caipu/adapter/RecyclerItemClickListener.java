package com.think.caipu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by think on 2018/1/14.
 */

public class RecyclerItemClickListener implements com.zhy.adapter.recyclerview.MultiItemTypeAdapter.OnItemClickListener {
    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }
}
