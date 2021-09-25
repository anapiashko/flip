package com.app.flip.services;

import com.app.flip.dao.CardRepository;
import com.app.flip.model.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Integer save(Card card) {
        return cardRepository.save(card).getId();
    }

    public List<Card> saveAll(List<Card> cards) {
        List<Card> savedCards = new ArrayList<>();
        cardRepository.saveAll(cards).forEach(savedCards::add);
        return savedCards;
    }
}
