package com.example.narasimha.newsapp;

/**
 * Created by narasimha on 28/3/18.
 */

public class NewsObject {
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;

    NewsObject(String author, String title, String description, String url, String urlToImage, String publishedAt){
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }
}
