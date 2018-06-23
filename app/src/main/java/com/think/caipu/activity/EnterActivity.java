package com.think.caipu.activity;

import com.example.demonstrate.DialogPage;
import com.example.demonstrate.FirstActivity;
import com.think.caipu.listener.DialogPage1Lis;

public class EnterActivity extends FirstActivity {

    @Override
    protected void click0() {
        DialogPage.getInstance().setOnDialogItemListener(new DialogPage1Lis(this));
    }
}
