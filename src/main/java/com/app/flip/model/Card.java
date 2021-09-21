package com.app.flip.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Card {

    private Integer id;
    @JsonProperty("en_sentence")
    private String englishSentence;
    @JsonProperty("rus_sentence")
    private String russianSentence;

    public Card (){}

    public Card(Integer id, String englishSentence, String russianSentence) {
        this.id = id;
        this.englishSentence = englishSentence;
        this.russianSentence = russianSentence;
    }
}
