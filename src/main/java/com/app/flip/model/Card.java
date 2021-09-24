package com.app.flip.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Card {

    @Id
    private Integer id;

    @Column(name = "en_sentence")
    @JsonProperty("en_sentence")
    private String englishSentence;

    @Column(name = "rus_sentence")
    @JsonProperty("rus_sentence")
    private String russianSentence;

    public Card (){}

    public Card(Integer id, String englishSentence, String russianSentence) {
        this.id = id;
        this.englishSentence = englishSentence;
        this.russianSentence = russianSentence;
    }
}
