package com.example.cook;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by think on 2018/1/14.
 */

interface MyServer {
    @GET("zhang721788/testmaterial/master/cookclassify.json")
    Call<CookBean> getCookMenu();

    //?type=caipu&keywords=%E5%AE%B6%E5%B8%B8%E8%8F%9C&page=1
    @GET("main6/search/byCaipu")
    Call<CookDiskBean> getCookDisk(@QueryMap Map<String, String> map);
}
