package com.app.flip.model;

import org.bson.types.Binary;

public class Card {

    private Integer id;
    private String englishSentence;
    private String russianSentence;
    private Binary record;

    public Card(Integer id, String englishSentence, String russianSentence, Binary record) {
        this.id = id;
        this.englishSentence = englishSentence;
        this.russianSentence = russianSentence;
        this.record = record;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnglishSentence() {
        return englishSentence;
    }

    public void setEnglishSentence(String englishSentence) {
        this.englishSentence = englishSentence;
    }

    public String getRussianSentence() {
        return russianSentence;
    }

    public void setRussianSentence(String russianSentence) {
        this.russianSentence = russianSentence;
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
                ", englishSentence='" + englishSentence + '\'' +
                ", russianSentence='" + russianSentence + '\'' +
                '}';
    }
}
