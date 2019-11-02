package com.example.prototype;

public class Message {
    String subject;
    String content;
    String from;
    String to;
    Organizer recipient;

    public Message(String subject, String contents, String from, String to) {
        this.subject = subject;
        this.content = contents;
        this.from = from;
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContents() {
        return content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

}
