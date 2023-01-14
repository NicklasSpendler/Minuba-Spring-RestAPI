package com.hovedopgave.restservice.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class PollResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String answer;
    private int count;

    public PollResult() {
    }

    public PollResult(long id, String answer, int count) {
        this.id = id;
        this.answer = answer;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PollResult{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", count=" + count +
                '}';
    }
}
