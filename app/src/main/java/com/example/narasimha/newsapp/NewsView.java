package com.example.narasimha.newsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by narasimha on 28/3/18.
 */

public class NewsView extends RecyclerView.Adapter<NewsView.ViewHolder> {
    ArrayList<NewsObject> newsObjects;
    @Override
    public NewsView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View news = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);

        return new NewsView.ViewHolder(news);
    }

    @Override
    public void onBindViewHolder(NewsView.ViewHolder holder, int position) {
        NewsObject newsObject = newsObjects.get(position);
        holder.title.setText(newsObject.title);
        holder.description.setText(newsObject.description);
        Ion.with(holder.banner).load(newsObject.urlToImage);
    }

    public NewsView(ArrayList<NewsObject> newsObjects){
        this.newsObjects = newsObjects;
    }

    @Override
    public int getItemCount() {
        return newsObjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView banner;
        TextView title;
        TextView description;
        Button readMore;
        public ViewHolder(View view){
            super(view);
            banner = (ImageView) view.findViewById(R.id.banner);
            title = (TextView)view.findViewById(R.id.headline);
            description = (TextView)view.findViewById(R.id.descr);
        }
    }
}
