package com.example.demonstrate.adapter.testname.p1.w4;

import android.app.Activity;

import com.example.demonstrate.R;
import com.example.demonstrate.adapter.testname.p1.BaseT6P1ILis;

/**
 * Created by think on 2018/3/13.
 */

public abstract class BaseT6P1W4ILis extends BaseT6P1ILis {
    public BaseT6P1W4ILis(Activity activity) {
        super(activity);
    }

    @Override
    protected int getWeekNumId() {
        return R.string.week_num4;
    }

}
