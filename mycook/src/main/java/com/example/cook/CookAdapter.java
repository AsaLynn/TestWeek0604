package com.example.cook;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cook.utils.UIUtils;
import com.truizlop.sectionedrecyclerview.SectionedRecyclerViewAdapter;

/**
 * Created by think on 2018/1/16.
 */

class CookAdapter extends SectionedRecyclerViewAdapter<HeaderHolder, ItemHolder, FootHolder> {

    private CookBean mCookBean;
    private int currenIndex;

    public CookAdapter(CookBean bean) {
        mCookBean = bean;
    }

    @Override
    protected int getSectionCount() {
        return mCookBean == null ? 0 : mCookBean.getCaipu().get(currenIndex).getTags().size();
    }

    @Override
    protected int getItemCountForSection(int section) {
        return mCookBean == null ? 0 : mCookBean.getCaipu().get(currenIndex).getTags().get(section).getData().size();
    }

    @Override
    protected boolean hasFooterInSection(int section) {
        return false;
    }

    @Override
    protected HeaderHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
        return new HeaderHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, null));
    }

    @Override
    protected FootHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected ItemHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cook_type, null));
    }

    @Override
    protected void onBindSectionHeaderViewHolder(HeaderHolder holder, int section) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.tv_tag.getLayoutParams();
        if (TextUtils.isEmpty(mCookBean.getCaipu().get(currenIndex).getTags().get(section).getName())) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            holder.header_ll.setVisibility(View.GONE);
        } else {
            holder.header_ll.setVisibility(View.VISIBLE);
            layoutParams.topMargin = UIUtils.dp2px(holder.tv_tag.getContext(), 10);
            layoutParams.bottomMargin = UIUtils.dp2px(holder.tv_tag.getContext(), 10);
            holder.tv_tag.setText(mCookBean.getCaipu().get(currenIndex).getTags().get(section).getName());
        }
        holder.tv_tag.setLayoutParams(layoutParams);
    }

    @Override
    protected void onBindSectionFooterViewHolder(FootHolder holder, int section) {
    }

    @Override
    protected void onBindItemViewHolder(ItemHolder holder, final int section, final int position) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.tv_item_name.getLayoutParams();
        if (position % 3 == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = UIUtils.dp2px(holder.tv_item_name.getContext(), 5);
        }
        layoutParams.bottomMargin = 5 * 3;
        holder.tv_item_name.setLayoutParams(layoutParams);
        String name = mCookBean.getCaipu().get(currenIndex).getTags().get(section).getData().get(position).getName();
        holder.tv_item_name.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnHolderClickListener) {
                    mOnHolderClickListener.onHolderClick(v, currenIndex, section, position);
                }
            }
        });

    }

    public void setCurrentAdapter(int index) {
        currenIndex = index;
        notifyDataSetChanged();
    }

    public interface OnHolderClickListener {
        void onHolderClick(View view, int index, int section, int position);
    }

    public void setOnHolderClickListener(OnHolderClickListener listener) {
        mOnHolderClickListener = listener;
    }


    private OnHolderClickListener mOnHolderClickListener;
}
