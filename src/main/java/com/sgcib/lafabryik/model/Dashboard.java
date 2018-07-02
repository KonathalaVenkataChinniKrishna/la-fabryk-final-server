package com.sgcib.lafabryik.model;

/**
 * Created by vkonatha061917 on 4/23/2018.
 */
public class Dashboard {

    private String srcFacebookName;

    private String name;

    private String facebookMessage;

    private String facebookTimestamp;

    private String sentiment;

    public Dashboard() {};

    public String getSrcFacebookName() {
        return srcFacebookName;
    }

    public void setSrcFacebookName(String srcFacebookName) {
        this.srcFacebookName = srcFacebookName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacebookMessage() {
        return facebookMessage;
    }

    public void setFacebookMessage(String facebookMessage) {
        this.facebookMessage = facebookMessage;
    }

    public String getFacebookTimestamp() {
        return facebookTimestamp;
    }

    public void setFacebookTimestamp(String facebookTimestamp) {
        this.facebookTimestamp = facebookTimestamp;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
}
