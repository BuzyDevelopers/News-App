package com.example.narasimha.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecView = findViewById(R.id.news_view);
        mRecView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecView.setLayoutManager(layoutManager);
        NewsLoader loader = new NewsLoader(this, mRecView, adapter, layoutManager);
        loader.loadNews();
    }
}
