package com.example.news.data;

import com.example.news.data.pojo.NewsRespond;
import com.example.news.data.reposetory.NewsReposetory;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Response;

public class NewsHeadLinesViewModel extends ViewModel {
    private NewsReposetory newsReposetory;
    private MutableLiveData<Response<NewsRespond>> allNews;

    public NewsHeadLinesViewModel() {
        newsReposetory = new NewsReposetory();
    }

    public MutableLiveData<Response<NewsRespond>> getAllNews(String endPoint, String language, String category, int pageSize, String apiKey) {
        allNews = newsReposetory.getNewsRespond(endPoint, language, category, pageSize,  apiKey);
        return allNews;
    }
}
