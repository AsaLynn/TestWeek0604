package com.example.cook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xadapter.OnXBindListener;
import com.xadapter.holder.XViewHolder;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CookDetailsActivity extends AppCompatActivity {

    @BindView(R.id.cook_details_rv)
    RecyclerView cookDetailsRv;
    private String TAG = this.getClass().getSimpleName();
    private CookDetailsAdapter cookDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coook_details);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        cookDetailsRv.setLayoutManager(new LinearLayoutManager(this) {
            {
                this.setOrientation(LinearLayoutManager.VERTICAL);
            }
        });
        cookDetailsRv.setHasFixedSize(true);
        cookDetailsRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        cookDetailsAdapter = new CookDetailsAdapter() {
            {
                this.setLayoutId(R.layout.item_recycler_main);
                this.onXBind(new OnXBindListener<CookDiskBean.DataBean.DishsBean>() {
                    @Override
                    public void onXBind(XViewHolder holder, int position, CookDiskBean.DataBean.DishsBean dishsBean) {
                        holder.setTextView(R.id.tv_disk_name, dishsBean.getName());
                        holder.setTextView(R.id.tv_content, dishsBean.getBurdens());
                        holder.setTextView(R.id.tv_time, dishsBean.getDishAddTime());
                        holder.setTextView(R.id.tv_type, dishsBean.getCustomers().getNickName());
                        holder.setTextView(R.id.tv_collect_num, dishsBean.getFavorites() + "收藏");
                        holder.setTextView(R.id.tv_browse_num, dishsBean.getAllClick() + "浏览");
                        Glide.with(CookDetailsActivity.this)
                                .load(dishsBean.getImg())
                                .apply(new RequestOptions().override(220, 150))
                                .into((ImageView) holder.getView(R.id.iv_disk));
                    }
                });
            }
        };
        cookDetailsRv.setAdapter(cookDetailsAdapter);

        if (!TextUtils.isEmpty(getIntent().getStringExtra(UC.KEYWORDS))) {
            request3(getIntent().getStringExtra(UC.KEYWORDS));
        } else {
            Toast.makeText(this, "部分参数没有传递过来!!!", Toast.LENGTH_SHORT).show();
        }
    }


    private void request3(final String keywords) {
        Observable.create(new ObservableOnSubscribe<CookDiskBean>() {
            @Override
            public void subscribe(ObservableEmitter<CookDiskBean> e) throws Exception {
                CookDiskBean bean = new Retrofit.Builder()
                        .baseUrl(UC.BASE_URL_XH)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(MyServer.class)
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
                    }

                    @Override
                    public void onNext(CookDiskBean dishsBean) {
                        Log.i(TAG, "onNext: ***" + dishsBean.toString());
                        Toast.makeText(CookDetailsActivity.this, "获取数据:" + dishsBean.toString(), Toast.LENGTH_SHORT).show();
                        cookDetailsAdapter.addAllData(dishsBean.getData().getDishs());
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

}
