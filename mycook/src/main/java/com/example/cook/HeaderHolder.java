package com.example.cook;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by think on 2018/1/16.
 */

class HeaderHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.tv_tag)
    TextView tv_tag;

    @BindView(R.id.header_ll)
    LinearLayout header_ll;


    public HeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
