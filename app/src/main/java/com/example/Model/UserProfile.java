package com.example.Model;

public class UserProfile {

    private String email;
    private String password;
    private String profilePicUrl;
    private String name;
    private String country;


    public UserProfile(String email, String password, String profilePicUrl, String name, String country) {
        this.email = email;
        this.password = password;
        this.profilePicUrl = profilePicUrl;
        this.name = name;
        this.country = country;
    }

    public UserProfile() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
