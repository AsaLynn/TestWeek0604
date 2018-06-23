package com.think.caipu.http;

import com.think.caipu.model.CookBookBean;
import com.think.caipu.model.CookDiskBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by think on 2018/1/14.
 */

public interface NetServer {
    @GET()
    Call<CookBookBean> getCookBook(@Url String url);

    @GET("zhang721788/testmaterial/master/caipu.json")
    Call<CookBookBean> getCookBook2();

    //?type=caipu&keywords=%E5%AE%B6%E5%B8%B8%E8%8F%9C&page=1
    @GET("main6/search/byCaipu")
    Call<CookDiskBean> getCookDisk(@QueryMap Map<String, String> map);
}
