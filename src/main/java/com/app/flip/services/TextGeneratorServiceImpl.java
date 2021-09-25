package com.app.flip.services;

import com.app.flip.model.Card;
import com.app.flip.utils.CardListHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class TextGeneratorServiceImpl {

    private final RestTemplate restTemplate;

    public TextGeneratorServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Card> getText() {
        log.info("getText");
        List<Card> cards =  Arrays.asList(
                Objects.requireNonNull(
                        restTemplate.getForObject("http://localhost:5000/analyze?title=health", Card[].class)
                ));
        cards = CardListHelper.getInstance(cards)
                .removeEmptyCards()
                .getCardsWithAverageSize()
                .collect();
        return cards;
    }
}
