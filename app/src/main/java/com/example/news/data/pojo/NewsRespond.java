package com.example.news.data.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsRespond {
    @SerializedName("articles")
    private List<News> news;
    private String status;
    private int totalResults;

    public List<News> getNews() {
        return news;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }
}
