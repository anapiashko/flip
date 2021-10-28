package com.app.flip.services;

import com.app.flip.dao.CardRepository;
import com.app.flip.model.Card;
import com.app.flip.model.Progress;
import com.app.flip.utils.CardTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final ProgressServiceImpl progressService;

    public CardServiceImpl(CardRepository cardRepository, ProgressServiceImpl progressService) {
        this.cardRepository = cardRepository;
        this.progressService = progressService;
    }

    @Override
    public List<Card> saveAll(List<Card> cards) {
        log.info("saveAll");
        List<Card> savedCards = new ArrayList<>();
        cardRepository.saveAll(cards).forEach(savedCards::add);

        List<Progress> progresses = savedCards.stream().map(card -> new Progress(card.getId())).collect(Collectors.toList());
        progressService.saveAll(progresses);
        return savedCards;
    }

    public List<Card> getSample(CardTopic cardTopic) {

        List<Card> resultCollection = new ArrayList<>();

        List<Card> newCards = cardRepository.findNewByCardTopic(cardTopic.name(), 5);
        List<Card> seenCards = cardRepository.findSeenByCardTopic(cardTopic.name(), 10);

        if (seenCards.size() < 10) {
            newCards.addAll(cardRepository.findNewByCardTopic(cardTopic.name(), 10));
            newCards = newCards.stream().distinct().collect(Collectors.toList());
        }

        resultCollection.addAll(newCards);
        resultCollection.addAll(seenCards);
        resultCollection = resultCollection.stream().limit(15).collect(Collectors.toList());

        return resultCollection;
    }
}
