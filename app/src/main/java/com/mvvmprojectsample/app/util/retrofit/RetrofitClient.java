package com.mvvmprojectsample.app.util.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Gson gson = new GsonBuilder().setLenient().create();
    private static String BASE_URL = "https://reqres.in/api/";
    private static Retrofit retrofit;

    public static RetrofitApi getRetroftApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitApi.class);
    }

}
