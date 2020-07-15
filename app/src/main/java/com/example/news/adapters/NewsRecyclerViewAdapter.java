package com.example.news.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.WebViewActivity;
import com.example.news.data.pojo.News;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsRecyclerViewViewHolder> {
    private static final String NEWSURL = "newsurl";
    private Context context;
    private List<News> news;
    private View view;

    public NewsRecyclerViewAdapter(Context context, List<News> news) {
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public NewsRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        NewsRecyclerViewViewHolder newsRecyclerViewViewHolder = new NewsRecyclerViewViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = newsRecyclerViewViewHolder.getBindingAdapterPosition();
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra(NEWSURL, news.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        return newsRecyclerViewViewHolder;
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewViewHolder holder, int position) {
        News newsPiece = news.get(position);
        holder.textView.setText(newsPiece.getTitle());
        Glide.with(context).load(newsPiece.getUrlToImage()).into(holder.imageView);

    }

     class NewsRecyclerViewViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public NewsRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.news_item_text_view);
            imageView = itemView.findViewById(R.id.news_image);
        }
    }
}
