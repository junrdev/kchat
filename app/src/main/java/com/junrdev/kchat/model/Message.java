package com.junrdev.kchat.model;

public class Message {

    private String content;

    private String sender;

    private String reciever;

    private String dateSent;

    private String characterCount;

    private Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public Message(String content, String sender, String reciever, String dateSent, String characterCount) {
        this.content = content;
        this.sender = sender;
        this.reciever = reciever;
        this.dateSent = dateSent;
        this.characterCount = characterCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(String characterCount) {
        this.characterCount = characterCount;
    }
}
