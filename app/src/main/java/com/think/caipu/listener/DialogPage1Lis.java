package com.think.caipu.listener;

import android.app.Activity;

import com.example.demonstrate.adapter.testname.p1.w4.BaseT6P1W4ILis;
import com.think.caipu.R;
import com.think.caipu.activity.MainActivity;

/**
 * Created by think on 2018/3/25.
 */

public class DialogPage1Lis extends BaseT6P1W4ILis {
    public DialogPage1Lis(Activity activity) {
        super(activity);
    }

    @Override
    public Class<?> getStartActivity(int which) {
        if (which == 0) {
            return MainActivity.class;
        } else if (which == 1) {

        }
        return null;
    }

    @Override
    public int getDialogListId() {
        return R.array.test6_week3_dialog1_items;
    }
}
