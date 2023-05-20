package com.example.courseanswering.Model;

public class Student {
    String name;
    Integer priority = 5;

    public Student(String name) {
        this.name = name;
    }

    Question[] questions = new Question[5];

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public String getName(){
        return name;
    }

    public boolean isAllAnswered() {
        for (Question question : questions) {
            if (question != null && !question.isAnswered()) {
                return false;
            }
        }
        return true;
    }
}
