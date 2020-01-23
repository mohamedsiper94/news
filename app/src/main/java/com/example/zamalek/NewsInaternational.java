package com.example.zamalek;

public class NewsInaternational {
    private  String Title;
    private String url;
    private  String url_imag;
    private String duration;
    private String description;

    public NewsInaternational(String title, String url, String url_imag, String duration,String description) {
        Title = title;
        this.url = url;
        this.url_imag = url_imag;
        this.duration = duration;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return Title;
    }

    public String getUrl() {
        return url;
    }

    public String getUrl_imag() {
        return url_imag;
    }

    public String getDuration() {
        return duration;
    }
}
