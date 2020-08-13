package com.example.news;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.adapters.NewsRecyclerViewAdapter;
import com.example.news.adapters.NewsViewPagerAdapter;
import com.example.news.data.NewsHeadLinesViewModel;
import com.example.news.data.pojo.News;
import com.example.news.data.pojo.NewsRespond;

import java.util.List;

public class NewsFragment extends Fragment {
    private static final String TAG = NewsFragment.class.getSimpleName();

    private final static String TOP_HEADLINES = "top-headlines";
    private final static String EVERYTHING = "everything";
    private final static String SOURCES = "sources";
    private final static String API_KEY = "3fa0412845664cc3aaa83eb4432c2300";
    private static final String ARABIC_LANGUAGE = "ar";
    private static final String COUNTRY = "eg";
    private static final int PAGE_SIZE = 100;
    private NewsHeadLinesViewModel newsViewModel;
    private NewsRecyclerViewAdapter recyclerViewAdapter;
    private static final String  categoryKey = "category";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.news_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        String category =  getArguments().getString(categoryKey);
        newsViewModel = ViewModelProviders.of(this).get(NewsHeadLinesViewModel.class);
        newsViewModel.getAllNews(TOP_HEADLINES, COUNTRY, category, PAGE_SIZE,  API_KEY)
                .observe(getViewLifecycleOwner(), new Observer<Response<NewsRespond>>() {
                    @Override
                    public void onChanged(Response<NewsRespond> newsRespondResponse) {
                        if (newsRespondResponse == null) {
                            Log.i(TAG, "response is null");
                        } else if (!newsRespondResponse.isSuccessful()) {
                          //  textView.setText("code: " + newsRespondResponse.code());
                        } else {
                            NewsRespond newsRespond = newsRespondResponse.body();
                            List<News> news = newsRespond.getNews();
                            recyclerViewAdapter = new NewsRecyclerViewAdapter(view.getContext(), news);
                            recyclerView.setAdapter(recyclerViewAdapter);
                        }
                    }
                });
        return view;
    }

}