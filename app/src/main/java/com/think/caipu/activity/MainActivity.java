package com.think.caipu.activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.think.caipu.R;
import com.think.caipu.adapter.RecyclerItemClickListener;
import com.think.caipu.adapter.RecyclerMainAdapter;
import com.think.caipu.adapter.RecyclerPopupAdapter;
import com.think.caipu.http.NetServer;
import com.think.caipu.model.CookBookBean;
import com.think.caipu.model.CookDiskBean;
import com.think.caipu.utils.UC;
import com.zxn.library.blackboxprogress.BlackBoxProgress;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView tvCook;
    protected RecyclerView recyclerMain;
    protected LinearLayout rootLl;
    private String TAG = this.getClass().getSimpleName();
    private Gson gson;
    private PopupWindow popupWindow;
    private CookBookBean mCookBookBean;
    private LinearLayoutManager manager;
    private DividerItemDecoration dividerItemDecoration;
    private RecyclerMainAdapter mainAdapter;
    private BlackBoxProgress boxProgress;
    private ProgressDialog appCompatDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
//        dialog1();
        dialog2();
        request();
        //request2();
    }

    private void dialog2() {
        if (null == appCompatDialog) {
            appCompatDialog = new ProgressDialog(this);
            appCompatDialog.setCancelable(false);
        }
        appCompatDialog.setMessage("加载中...");
        if (!appCompatDialog.isShowing()) {
            appCompatDialog.show();
        }
    }

    private void request2() {

        gson = new Gson();
        Observable.create(new ObservableOnSubscribe<CookBookBean>() {
            @Override
            public void subscribe(ObservableEmitter<CookBookBean> e) throws Exception {
                String string = new OkHttpClient.Builder()
                        .build()
                        .newCall(new Request.Builder().url(UC.URL_COOK).build())
                        .execute().body().string();
                CookBookBean cookBookBean = gson.fromJson(string, CookBookBean.class);

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CookBookBean>() {
                    @Override
                    public void accept(CookBookBean cookBookBean) throws Exception {
                        Log.i(TAG, "accept: ***" + cookBookBean.toString());
                    }
                });

    }

    private void request() {

        Observable.create(new ObservableOnSubscribe<CookBookBean>() {
            @Override
            public void subscribe(ObservableEmitter<CookBookBean> e) throws Exception {
                CookBookBean cookBookBean = new Retrofit.Builder()
                        .baseUrl(UC.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(NetServer.class)
                        .getCookBook2()
                        .execute().body();
                e.onNext(cookBookBean);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CookBookBean>() {
                    @Override
                    public void accept(CookBookBean cookBookBean) throws Exception {
                        Toast.makeText(MainActivity.this, "" + cookBookBean.toString(), Toast.LENGTH_SHORT).show();
                        Log.i(TAG, "accept: " + cookBookBean.toString());
                        mCookBookBean = cookBookBean;
                        if (boxProgress != null) {
                            boxProgress.dismiss();
                        }
                        if (null != appCompatDialog) {
                            appCompatDialog.dismiss();
                        }
                    }
                });
    }

    private void dialog1() {
        boxProgress = BlackBoxProgress.create(this)
                .setStyle(BlackBoxProgress.Style.SPIN_INDETERMINATE)
                .setLabel("请稍后...")
                .show();
    }

    private void initView() {
        tvCook = (TextView) findViewById(R.id.tv_cook);
        tvCook.setOnClickListener(MainActivity.this);
        rootLl = (LinearLayout) findViewById(R.id.root_ll);
        recyclerMain = (RecyclerView) findViewById(R.id.recycler_main);
        recyclerMain.setHasFixedSize(true);
        manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerMain.setLayoutManager(manager);
        dividerItemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
        //dividerItemDecoration.setDrawable();
        recyclerMain.addItemDecoration(dividerItemDecoration);
        mainAdapter = new RecyclerMainAdapter(MainActivity.this, new ArrayList<CookDiskBean.DataBean.DishsBean>());
        mainAdapter.setOnItemClickListener(new RecyclerItemClickListener() {
            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                Toast
                        .makeText(MainActivity.this,
                                "选择了:" + mainAdapter.getDatas().get(position).getName(),
                                Toast.LENGTH_SHORT)
                        .show();
                return true;
            }
        });
        recyclerMain.setAdapter(mainAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_cook) {
            if (mCookBookBean != null) {
                showPopup();
            } else {
                Toast.makeText(this, "数据还未获取到,请稍等!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showPopup() {
        if (null == popupWindow) {
            popupWindow = new PopupWindow(this);
            popupWindow.setWidth(rootLl.getWidth());
            popupWindow.setHeight((rootLl.getHeight() / 3) * 2);
            View popView = View.inflate(this, R.layout.layout_pop, null);
            RadioGroup radioGroup = popView.findViewById(R.id.rg);
            RecyclerView recycler_pop = popView.findViewById(R.id.recycler_pop);

            recycler_pop.setHasFixedSize(true);
            recycler_pop.setLayoutManager(new LinearLayoutManager(MainActivity.this) {
                {
                    this.setOrientation(VERTICAL);
                }
            });

            recycler_pop.addItemDecoration(dividerItemDecoration);
            final ArrayList<CookBookBean.CaipuBean.DataBean> popDatas = new ArrayList<>();
            final RecyclerPopupAdapter popupAdapter = new RecyclerPopupAdapter(MainActivity.this, popDatas);
//            popupAdapter.addItemViewDelegate(new MyItemViewDelegate());
            popupAdapter.setOnItemClickListener(new RecyclerItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    Toast.makeText(MainActivity.this, "亲,选择了:" + popupAdapter.getDatas().get(position).getName(), Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                    tvCook.setText(popupAdapter.getDatas().get(position).getName());
                    request3(popupAdapter.getDatas().get(position).getName());
                }
            });
            recycler_pop.setAdapter(popupAdapter);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                    group.findViewsWithText();
//                    group.findViewWithTag()
                    int childIndex = group.indexOfChild(group.findViewById(checkedId));
                    popupAdapter.getDatas().clear();
                    popupAdapter.getDatas().addAll(mCookBookBean.getCaipu().get(childIndex).getData());
                    popupAdapter.notifyDataSetChanged();
                }
            });

            ViewGroup.LayoutParams layoutParams = radioGroup.getLayoutParams();
            layoutParams.width = RadioGroup.LayoutParams.MATCH_PARENT;
            //12dp---->转换成像素
            int dpValue = 12;
            int pxValue = dp2px(dpValue);
            int top = pxValue;
            int bottom = pxValue;
            for (int i = 0; i < mCookBookBean.getCaipu().size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setId(i);
                radioButton.setChecked(false);
                radioButton.setText(mCookBookBean.getCaipu().get(i).getName());
                radioButton.setTextColor(getResources().getColorStateList(R.color.rb_c_sc));
                radioButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                radioButton.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
                radioButton.setBackgroundResource(R.drawable.bg_rb_d_sc);
                radioButton.setLayoutParams(layoutParams);
                radioButton.setPadding(0, top, 0, bottom);
                radioButton.setGravity(Gravity.CENTER);
                radioGroup.addView(radioButton);
            }
            popupWindow.setContentView(popView);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

            RadioButton rb = (RadioButton) radioGroup.getChildAt(0);
            rb.setChecked(true);
        }
        if (popupWindow.isShowing()) {
//            popupWindow.showAsDropDown(tvCook);
            return;
        }
        popupWindow.showAsDropDown(tvCook, 0, dp2px(2));
    }

    private void request3(final String keywords) {
        Observable.create(new ObservableOnSubscribe<CookDiskBean>() {
            @Override
            public void subscribe(ObservableEmitter<CookDiskBean> e) throws Exception {
                CookDiskBean bean = new Retrofit.Builder()
                        .baseUrl(UC.BASE_URL_XH)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(NetServer.class)
                        .getCookDisk(new HashMap<String, String>() {
                            {
                                //?type=caipu&keywords=%E5%AE%B6%E5%B8%B8%E8%8F%9C&page=1
                                put("type", "caipu");
                                put("keywords", keywords);
                                put("page", "1");
                            }
                        }).execute()
                        .body();
                e.onNext(bean);
                Log.i(TAG, "subscribe: ***Retrofit");
                Log.i(TAG, "onSubscribe: ***Threadname***" + Thread.currentThread().getName() + "***--id" + Thread.currentThread().getId());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CookDiskBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe: ***Threadname***" + Thread.currentThread().getName() + "***--id" + Thread.currentThread().getId());
                        dialog2();
                    }

                    @Override
                    public void onNext(CookDiskBean dishsBean) {
                        Log.i(TAG, "onNext: ***" + dishsBean.toString());
                        Toast.makeText(MainActivity.this, "获取数据:" + dishsBean.toString(), Toast.LENGTH_SHORT).show();
                        String json = null;
                        if (null == gson) {
                            gson = new Gson();
                        }
                        json = gson.toJson(dishsBean);
                        Log.i(TAG, json);
                        mainAdapter.getDatas().clear();
                        mainAdapter.getDatas().addAll(dishsBean.getData().getDishs());
                        mainAdapter.notifyDataSetChanged();
                        if (null != appCompatDialog) {
                            appCompatDialog.dismiss();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: ***");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: ***");
                    }
                });
    }

    private int dp2px(int dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
