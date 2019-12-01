package com.darakay.patterns.message;

public class Message implements IMessage{
    private String from;
    private String to;
    private String text;

    public Message(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public String getRecipientName() {
        return to;
    }

    public String getAuthorName() {
        return from;
    }

    public String getText() {
        return text;
    }
}
