package com.example.courseanswering.Model;

public class Question {
    Boolean isAnswered = false;
    private final String content;
    private final Long expectTime;

    private Integer priority = 3;

    public Question(String content, Long expectTime) {
        this.content = content;
        this.expectTime = expectTime;
    }

    public String getContent() {
        return content;
    }

    public Long getExpectTime() {
        return expectTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
