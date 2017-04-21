package com.dhcc.mvp.model.base;

import com.dhcc.mvp.model.bean.Info;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Lituo on 2017/4/20 0020. 22:23 .
 * Mail：tony1994_vip@163.com
 */

public class RetrofitUtil {

    private static final String baseUrl = "http://japi.juhe.cn/joke/content/";

    private Retrofit mRetrofit;

    private IRetrofitServer mServer;


    //唯一实例
    private static RetrofitUtil sInstance;


    private RetrofitUtil() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mServer = mRetrofit.create(IRetrofitServer.class);
    }

    public static RetrofitUtil getInstance() {
        if (null == sInstance) {
            synchronized (RetrofitUtil.class) {
                if (null == sInstance) {
                    sInstance = new RetrofitUtil();
                }
            }
        }
        return sInstance;
    }

    public interface IRetrofitServer {
        String getUrl = "list.from";
        String postUrl = "list.from";

        /**
         * Get请求
         *
         * @param key
         * @param sort
         * @param time
         * @return
         */
        @GET(getUrl)
        Call<Info> get(@Query("key") String key, @Query("sort") String sort, @Query("time") String time);

        /**
         * 封装好Url的Get的请求
         *
         * @return
         */
        @GET(getUrl + "?key=488c65f3230c0280757b50686d1f1cd5&&sort=asc&&time=1418816972")
        Call<Info> get();

        /**
         * Get Map键值对请求
         *
         * @param map
         * @return
         */
        @GET(getUrl)
        Call<Info> get(@QueryMap HashMap<String, String> map);

        /**
         * Post 参数
         *
         * @param key
         * @param sort
         * @param time
         * @return
         */
        @FormUrlEncoded
        @POST(postUrl)
        Call<Info> post(@Field("key") String key, @Field("sort") String sort, @Field("time") String time);

        /**
         * post  Map键值对
         *
         * @param map
         * @return
         */
        @FormUrlEncoded
        @POST(postUrl)
        Call<Info> post(@FieldMap HashMap<String, String> map);

    }
}
