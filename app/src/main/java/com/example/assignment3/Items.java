package com.example.assignment3;

public class Items {

    private String title;
    private String author;
    private String level;
    private String info;
    private String authorUr;
    private String url;
    private String cover;

 public Items(){

 }
    public Items(String title, String author, String level, String info, String authorUr, String url, String cover) {
        this.title = title;
        this.author = author;
        this.level = level;
        this.info = info;
        this.authorUr = authorUr;
        this.url = url;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAuthorUr() {
        return authorUr;
    }

    public void setAuthorUr(String authorUr) {
        this.authorUr = authorUr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
