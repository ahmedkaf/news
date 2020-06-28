package com.example.news.adapters;

import android.os.Bundle;


import com.example.news.NewsFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NewsViewPagerAdapter extends FragmentStateAdapter {
    private final String general = "general";
    private final String entertainment = "entertainment";
    private final String health = "health";
    private final String business = "business";
    private final String science = "science";
    private final String sports = "sports";
    private final String technology = "technology";
    private final String category = "category";

    public NewsViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return createNewsFragment(position);
    }

    @Override
    public int getItemCount() {
        return 7;
    }



    private NewsFragment createNewsFragment(int position){
        NewsFragment newsFragment = new NewsFragment();
        Bundle args = new Bundle();
        switch(position){
            case 0:
                args.putString(category, general);
                break;
            case 1:
                args.putString(category, entertainment);
                break;
            case 2:
                args.putString(category, health);
                break;
            case 3:
                args.putString(category, business);
                break;
            case 4:
                args.putString(category, science);
                break;
            case 5:
                args.putString(category, sports);
                break;
            case 6:
                args.putString(category, technology);
                break;
            default:
                args.putString(category, general);
        }
        newsFragment.setArguments(args);
        return newsFragment;
    }
}
