package com.dhcc.mvp.model.base;

import com.dhcc.mvp.model.api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Lituo on 2017/4/10 0010. 10:51 .
 * Mail：tony1994_vip@163.com
 */

public class VisaClient {

    //唯一实例
    private static VisaClient sInstance;

    private OkHttpClient mOkHttpClient;

    private VisaClient() {
        //日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static VisaClient getInstance() {
        if (null == sInstance) {
            synchronized (VisaClient.class) {
                if (null == sInstance) {
                    sInstance = new VisaClient();
                }
            }
        }
        return sInstance;
    }

    /**
     * 获取美女图片
     */
    public void test(Callback callback) {
        Request request = new Request.Builder()
                .url(Api.NEWS_BEAUTY)
                .get()
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }



    /**
     * 获取美女图片
     */
    public void beauty(Callback callback) {
        Request request = new Request.Builder()
                .url(Api.NEWS_BEAUTY)
                .get()
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }


}
