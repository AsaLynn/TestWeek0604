package com.example.cook;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by think on 2018/1/16.
 */

class GridItemDecoration extends RecyclerView.ItemDecoration {

    private int itemSpace;
    private int columnNum;

    public GridItemDecoration(int itemSpace, int columnNum) {
        this.itemSpace = itemSpace;
        this.columnNum = columnNum;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        CookAdapter adapter = (CookAdapter) parent.getAdapter();
        int childLayoutPosition = parent.getChildLayoutPosition(view);
        if (!adapter.isSectionHeaderPosition(childLayoutPosition) && !adapter.isSectionFooterPosition(childLayoutPosition)){
            outRect.bottom = itemSpace * 3;
            int sectionCount = adapter.getSectionCount();
            for (int i = 0; i < sectionCount; i++) {
                int countForSection = adapter.getItemCountForSection(i);
                for (int j = 0; j < countForSection; j++) {
                    if (j % columnNum == 0){
                        outRect.left = 0;
                    }else {
                        outRect.left = itemSpace;
                    }
                }
            }
        }else if (adapter.isSectionFooterPosition(childLayoutPosition)){
            outRect.bottom = 0;
        }
    }
}
