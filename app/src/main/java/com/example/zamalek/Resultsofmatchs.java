package com.example.zamalek;

public class Resultsofmatchs {
    String name_home,name_away,date,score,time_now,name_lega,status,location;

    public Resultsofmatchs(String name_home, String name_away, String date, String score, String time_now, String name_lega, String status, String location) {
        this.name_home = name_home;
        this.name_away = name_away;
        this.date = date;
        this.score = score;
        this.time_now = time_now;
        this.name_lega = name_lega;
        this.status = status;
        this.location = location;
    }


    public String getName_home() {
        return name_home;
    }

    public String getName_away() {
        return name_away;
    }

    public String getDate() {
        return date;
    }

    public String getScore() {
        return score;
    }

    public String getTime_now() {
        return time_now;
    }

    public String getName_lega() {
        return name_lega;
    }

    public String getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }
}
