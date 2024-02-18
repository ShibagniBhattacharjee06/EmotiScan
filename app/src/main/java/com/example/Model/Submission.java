package com.example.Model;

public class Submission {
//    private String downloadUrl;
    private String mood;
    private String fulldetails;
    private String items;
    private String userId;
    private String date;


    public Submission() {
    }

    public Submission(String mood, String fulldetails, String items, String date) {
        this.mood = mood;
        this.fulldetails = fulldetails;
        this.items = items;
        this.date = date;
    }



    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getFulldetails() {
        return fulldetails;
    }

    public void setFulldetails(String fulldetails) {
        this.fulldetails = fulldetails;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
