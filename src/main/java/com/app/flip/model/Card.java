package com.app.flip.model;

import org.bson.types.Binary;

public class Card {

    private Integer id;
    private String sentence;
    private Binary record;

    public Card(Integer id, String sentence, Binary record) {
        this.id = id;
        this.sentence = sentence;
        this.record = record;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Binary getRecord() {
        return record;
    }

    public void setRecord(Binary record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
