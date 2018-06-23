package com.think.caipu.adapter;

import android.content.Context;

import com.think.caipu.R;
import com.think.caipu.model.CookBookBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by think on 2018/1/14.
 */

public class RecyclerPopupAdapter extends CommonAdapter<CookBookBean.CaipuBean.DataBean> {

    public RecyclerPopupAdapter(Context context, List<CookBookBean.CaipuBean.DataBean> datas) {
        super(context, R.layout.item_popup_recycler, datas);
    }

    @Override
    protected void convert(ViewHolder holder, CookBookBean.CaipuBean.DataBean dataBean, int position) {
        holder.setText(R.id.tv_item_pop, dataBean.getName());
    }
}
