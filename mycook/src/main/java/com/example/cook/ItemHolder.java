package com.example.cook;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by think on 2018/1/16.
 */

class ItemHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.tv_item_name)
    TextView tv_item_name;
    public ItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }
}
