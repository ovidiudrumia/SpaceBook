package com.cegeka.spacebook;

import java.util.Date;

public class Message {
    private Person sender;
    private String body;
    private Date date;

    public Message(Person sender, String body) {
        this.sender = sender;
        this.body = body;
        this.date = new Date();
    }

    public Person getSender() {
        return sender;
    }

    public String getBody() {
        return body;
    }

    public Date getDate() {
        return date;
    }
}
