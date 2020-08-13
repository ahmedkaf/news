package com.example.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager2.widget.ViewPager2;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.news.adapters.NewsViewPagerAdapter;
import com.example.news.data.Countries;
import com.example.news.data.NewsHeadLinesViewModel;
import com.example.news.data.pojo.News;
import com.example.news.data.pojo.NewsRespond;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final String general = "general";
    private final String entertainment = "entertainment";
    private final String health = "health";
    private final String business = "business";
    private final String science = "science";
    private final String sports = "sports";
    private final String technology = "technology";
    ViewPager2 viewPager2;
    NewsViewPagerAdapter newsViewPagerAdapter;
    TabLayout tabLayout;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        viewPager2 = findViewById(R.id.news_view_pager2);
        newsViewPagerAdapter = new NewsViewPagerAdapter(this);
        viewPager2.setAdapter(newsViewPagerAdapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open
                , R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

       tabLayout = findViewById(R.id.news_tab_layout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch(position){
                    case 0:
                        tab.setText(general);
                        break;
                    case 1:
                        tab.setText(entertainment);
                        break;
                    case 2:
                        tab.setText(health);
                        break;
                    case 3:
                        tab.setText(business);
                        break;
                    case 4:
                        tab.setText(science);
                        break;
                    case 5:
                        tab.setText(sports);
                        break;
                    case 6:
                        tab.setText(technology);
                        break;
                    default:
                        tab.setText(general);
                }
            }
        });
        tabLayoutMediator.attach();
        Countries countries = new Countries();
        countries.getCountryArray();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}