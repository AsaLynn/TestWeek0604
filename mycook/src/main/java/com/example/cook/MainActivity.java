package com.example.cook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btnType1;
    protected Button btnType2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_type1) {
            startActivity(new Intent(this,CookType1Activity.class));
        } else if (view.getId() == R.id.btn_type2) {
            startActivity(new Intent(this,CookType2Activity.class));
        }
    }

    private void initView() {
        btnType1 = (Button) findViewById(R.id.btn_type1);
        btnType1.setOnClickListener(MainActivity.this);
        btnType2 = (Button) findViewById(R.id.btn_type2);
        btnType2.setOnClickListener(MainActivity.this);
    }
}
