package com.example.news.data.dataSource;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApiRetrofit {
    private final static String BASE_URL =
            "http://newsapi.org/";

    public static JsonNewsApi createRetrofitService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(JsonNewsApi.class);
    }
}
