package com.chous.wordle;

public class Letter {
    private Status status;
    private String text;

    Letter(String text) {
        status = Status.NONE;
        this.text = text;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getText(){
        return text;
    }

    public enum Status {
        NONE, ABSENT, PRESENT, CORRECT
    }
}
