package com.example.news.data.dataSource;

import com.example.news.data.pojo.NewsRespond;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonNewsApi {

    @GET("v2/{endPoint}")
    Call<NewsRespond> getNews(@Path("endPoint") String endPoint, @Query("country") String country,
                              @Query("category") String category, @Query("pageSize") int pageSize,
                              @Query("apiKey") String apiKey);
}
