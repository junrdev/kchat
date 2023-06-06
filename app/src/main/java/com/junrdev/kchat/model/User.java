package com.junrdev.kchat.model;

public class User {

    private String email;

    private String userName;

    private String dateJoined;

    private String uid;

    private String description;

    private User() {
    }

    public User(String email, String userName, String dateJoined, String uid, String description, int profilePicLink) {
        this.email = email;
        this.userName = userName;
        this.dateJoined = dateJoined;
        this.uid = uid;
        this.description = description;
        this.profilePicLink = profilePicLink;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int profilePicLink;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public int getProfilePicLink() {
        return profilePicLink;
    }

    public void setProfilePicLink(int profilePicLink) {
        this.profilePicLink = profilePicLink;
    }
}
