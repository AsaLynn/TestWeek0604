package com.think.caipu.holder;

import com.think.caipu.R;
import com.think.caipu.model.CookBookBean;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by think on 2018/1/14.
 */

class MyItemViewDelegate implements ItemViewDelegate<CookBookBean.CaipuBean.DataBean> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_popup_delegate;
    }

    @Override
    public boolean isForViewType(CookBookBean.CaipuBean.DataBean item, int position) {
        return true;
    }

    @Override
    public void convert(ViewHolder holder, CookBookBean.CaipuBean.DataBean dataBean, int position) {
        holder.setText(R.id.tv_delegate, "position" + position);
    }
}
