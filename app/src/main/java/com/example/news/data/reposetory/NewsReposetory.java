package com.example.news.data.reposetory;

import android.util.Log;

import com.example.news.data.dataSource.JsonNewsApi;
import com.example.news.data.dataSource.NewsApiRetrofit;
import com.example.news.data.pojo.NewsRespond;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsReposetory {
    private static final String TAG = NewsReposetory.class.getSimpleName();
    JsonNewsApi jsonNewsApi;

    public NewsReposetory() {
        NewsApiRetrofit newsApiRetrofit = new NewsApiRetrofit();
        jsonNewsApi = newsApiRetrofit.createRetrofitService();
    }

    public MutableLiveData<Response<NewsRespond>> getNewsRespond(String endPoint, String country, String category,
                                                                 int pageSize, String apiKey){
        Call<NewsRespond> call = jsonNewsApi.getNews(endPoint, country, category,pageSize, apiKey);
        MutableLiveData<Response<NewsRespond>> newsRespond = new MutableLiveData<>();
        call.enqueue(new Callback<NewsRespond>() {
            @Override
            public void onResponse(Call<NewsRespond> call, Response<NewsRespond> response) {
                if(response.isSuccessful()){
                    newsRespond.setValue(response);
                    Log.i(TAG, "response successful");
                }
            }

            @Override
            public void onFailure(Call<NewsRespond> call, Throwable t) {
                Log.e(TAG, t.getMessage());
                newsRespond.setValue(null);
            }
        });
        return newsRespond;
    }
}
