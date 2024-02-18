package com.example.Model;

import java.util.Map;

public class Post {

    private String text;
    private Map<String, Boolean> checkboxValues;
    private String userId;
    private String name;

    // Constructor

    public Post() {
    }

    public Post(String text, Map<String, Boolean> checkboxValues, String userId, String name) {
        this.text = text;
        this.checkboxValues = checkboxValues;
        this.userId = userId;
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Boolean> getCheckboxValues() {
        return checkboxValues;
    }

    public void setCheckboxValues(Map<String, Boolean> checkboxValues) {
        this.checkboxValues = checkboxValues;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
