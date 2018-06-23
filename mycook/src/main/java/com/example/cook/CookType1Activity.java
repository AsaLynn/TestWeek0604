package com.example.cook;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.truizlop.sectionedrecyclerview.SectionedSpanSizeLookup;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CookType1Activity extends AppCompatActivity {

    protected RadioGroup rgType1;
    protected ScrollView scType1;
    protected RecyclerView rvType1;
    protected LinearLayout constraintCl;
    private String TAG = this.getClass().getSimpleName();
    private CookAdapter cookAdapter;
    private CookBean mCookBean;
    private GridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_cook_type1);
        initView();
        request();
    }

    private void request() {
        Observable.create(new ObservableOnSubscribe<CookBean>() {
            @Override
            public void subscribe(ObservableEmitter<CookBean> e) throws Exception {
                CookBean cookBean = new Retrofit.Builder()
                        .baseUrl(UC.BASE_URL_GIT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(MyServer.class)
                        .getCookMenu()
                        .execute()
                        .body();
                e.onNext(cookBean);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CookBean>() {
                    @Override
                    public void accept(CookBean cookBean) throws Exception {
                        Toast.makeText(CookType1Activity.this, "" + cookBean.toString(), Toast.LENGTH_SHORT).show();
                        Log.i(TAG, "accept: " + cookBean.toString());
                        mCookBean = cookBean;
                        refreshView(cookBean);
                    }
                });
    }

    private void refreshView(CookBean cookBean) {
        ViewGroup.LayoutParams layoutParams = rgType1.getLayoutParams();
        layoutParams.width = RadioGroup.LayoutParams.MATCH_PARENT;
        //12dp---->转换成像素
        int dpValue = 12;
        int pxValue = dp2px(dpValue);
        int top = pxValue;
        int bottom = pxValue;
        cookAdapter = new CookAdapter(mCookBean);
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(cookAdapter, manager));
        rvType1.setLayoutManager(manager);
        rvType1.setAdapter(cookAdapter);
        cookAdapter.setOnHolderClickListener(new CookAdapter.OnHolderClickListener() {
            @Override
            public void onHolderClick(View view, int index, int section, int position) {
                Intent intent = new Intent(CookType1Activity.this, CookDetailsActivity.class);
                intent.putExtra(UC.KEYWORDS, mCookBean.getCaipu().get(index).getTags().get(section).getData().get(position).getName());
                startActivity(intent);
            }
        });


        for (int i = 0; i < cookBean.getCaipu().size(); i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i);
            radioButton.setChecked(false);
            radioButton.setText(cookBean.getCaipu().get(i).getName());
            radioButton.setTextColor(getResources().getColorStateList(R.color.rb_c_sc));
            radioButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            radioButton.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
            radioButton.setBackgroundResource(R.drawable.bg_rb_d_sc);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setPadding(0, top, 0, bottom);
            radioButton.setGravity(Gravity.CENTER);
            rgType1.addView(radioButton);
        }


        RadioButton rb = (RadioButton) rgType1.getChildAt(0);
        rb.setChecked(true);

    }


//    private ArrayList<CookBean.CaipuBean.TagsBean> caipuBeans = new ArrayList<>();

    private void initView() {
        constraintCl = (LinearLayout) findViewById(R.id.constraint_cl);
        rgType1 = (RadioGroup) findViewById(R.id.rg_type1);
        rgType1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = group.indexOfChild(group.findViewById(checkedId));
                cookAdapter.setCurrentAdapter(index);
            }
        });
        scType1 = (ScrollView) findViewById(R.id.sc_type1);
        rvType1 = (RecyclerView) findViewById(R.id.rv_type1);
        rvType1.setHasFixedSize(true);
//        rvType1.addItemDecoration(new GridItemDecoration(6,3));
        manager = new GridLayoutManager(this, 3);

    }

    private int dp2px(int dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
