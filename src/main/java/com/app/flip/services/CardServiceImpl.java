package com.app.flip.services;

import com.app.flip.dao.CardRepository;
import com.app.flip.model.Card;
import com.app.flip.utils.CardTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

   @Override
    public List<Card> saveAll(List<Card> cards) {
        log.info("saveAll");
        List<Card> savedCards = new ArrayList<>();
        cardRepository.saveAll(cards).forEach(savedCards::add);
        return savedCards;
    }

    public List<Card> getSample(CardTopic cardTopic){
        return cardRepository.findByCardTopic(cardTopic.name());
    }
}
