package fr.ensim.interop.eval.exo3.models;

public class Message {
    private String content;
    private String dateTime;
    private String sender;

    public Message(String content, String dateTime, String sender) {
        this.content = content;
        this.dateTime = dateTime;
        this.sender = sender;
    }

    public Message(){}


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
