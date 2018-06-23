package com.think.caipu.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.think.caipu.R;
import com.think.caipu.model.CookDiskBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by think on 2018/1/14.
 */

public class RecyclerMainAdapter extends CommonAdapter<CookDiskBean.DataBean.DishsBean> {

    public RecyclerMainAdapter(Context context, List<CookDiskBean.DataBean.DishsBean> datas) {
        super(context, R.layout.item_recycler_main, datas);
    }

    @Override
    protected void convert(ViewHolder holder, CookDiskBean.DataBean.DishsBean dishsBean, int position) {
        holder.setText(R.id.tv_disk_name, dishsBean.getName())
                .setText(R.id.tv_content, dishsBean.getBurdens())
                .setText(R.id.tv_time, dishsBean.getDishAddTime())
                .setText(R.id.tv_type, dishsBean.getCustomers().getNickName())
                .setText(R.id.tv_collect_num, dishsBean.getFavorites() + "收藏")
                .setText(R.id.tv_browse_num, dishsBean.getAllClick() + "浏览");
        Glide.with(mContext)
                .load(dishsBean.getImg())
                .apply(new RequestOptions().override(220, 150))
                .into((ImageView) holder.getView(R.id.iv_disk));


    }
}
