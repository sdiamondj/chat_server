package cn.edu.ncu.chat_server.entity;

import java.security.Timestamp;
import java.util.Date;

public class Session {
    private Integer sessionId;

    private Integer userId;

    private String sessionContent;

    private String time;

    private Integer talkerId;

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSessionContent() {
        return sessionContent;
    }

    public void setSessionContent(String sessionContent) {
        this.sessionContent = sessionContent == null ? null : sessionContent.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTalkerId() {
        return talkerId;
    }

    public void setTalkerId(Integer talkerId) {
        this.talkerId = talkerId;
    }
}