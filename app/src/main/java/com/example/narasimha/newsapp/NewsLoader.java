package com.example.narasimha.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by narasimha on 28/3/18.
 */

public class NewsLoader {
    Context c;

    final  String API_KEY = "38d2e917e0394962bd63636506e13c69";

    RecyclerView mView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    public NewsLoader(Context c, RecyclerView view, RecyclerView.Adapter adapter, RecyclerView.LayoutManager mgr){
        this.c = c;
        this.mView = view;
        this.mAdapter = adapter;
        this.layoutManager = mgr;
    }

    public ArrayList<NewsObject> loadNews(){
        ArrayList<NewsObject> newsObjects= new ArrayList<NewsObject>();
        getNewsUpdate(newsObjects);
        return null;
    }

    private void getNewsUpdate(ArrayList<NewsObject> array) {
        Toast.makeText(c, "Getting news", Toast.LENGTH_SHORT).show();
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + API_KEY;
        Ion.with(c).load("GET", url).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                if (e != null) Toast.makeText(c, e.toString(), Toast.LENGTH_SHORT).show();
                else {
                    JsonArray arr = result.getAsJsonArray("articles");
                    ArrayList<NewsObject> objects = new ArrayList<NewsObject>();
                    for(JsonElement element : arr) {
                        NewsObject newsObject = new Gson().fromJson(element, NewsObject.class);
                        objects.add(newsObject);
                    }
                    updateUIWithNews(objects);
                }
            }
        });
    }

    public void updateUIWithNews(ArrayList<NewsObject> objects){
        mAdapter = new NewsView(objects);
        mView.setAdapter(mAdapter);
    }
}
