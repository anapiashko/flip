package com.app.flip.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "en_sentence")
    @JsonProperty("en_sentence")
    private String englishSentence;

    @Column(name = "rus_sentence")
    @JsonProperty("rus_sentence")
    private String russianSentence;

    private Integer missedWord;

    @Column(name = "topic")
    @JsonProperty("topic")
    @Enumerated
    private CardTopic cardTopic;

    private String location;

    public Card (){}

    public Card(Integer id, String englishSentence, String russianSentence, Integer missedWord,
                CardTopic cardTopic, String location) {
        this.id = id;
        this.englishSentence = englishSentence;
        this.russianSentence = russianSentence;
        this.missedWord = missedWord;
        this.cardTopic = cardTopic;
        this.location = location;
    }
}
