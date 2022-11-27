package com.app.flip.services;

import com.app.flip.dao.CardRepository;
import com.app.flip.model.*;
import com.app.flip.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
        log.info("Save all generated cards to database");
        List<Card> savedCards = new ArrayList<>();
        for (Card card : cards) {
            try {
                Card savedCard = cardRepository.save(card);
                savedCards.add(savedCard);
            } catch (DataIntegrityViolationException d) {
                log.error("Not unique value, card {} , {}", card, d.getMessage());
            } catch (Exception e) {
                log.error("Error saving card {}, {} ", card, e.getMessage());
            }
        }

        List<Progress> progresses = savedCards.stream()
                .map(Card::getId)
                .map(Progress::new)
                .collect(Collectors.toList());
        progressService.saveAll(progresses);
        return savedCards;
    }

    public List<Card> getSample(CardTopic cardTopic, User user) {
        log.info("Getting sample by topic = {}", cardTopic);

        List<Card> resultCollection = new ArrayList<>();

        List<Card> newCards = cardRepository.findNewByCardTopic(user.getId(), cardTopic.getOrdinal(), Constants.NEW_CARDS_SIZE);
        List<Card> seenCards = cardRepository.findSeenByCardTopic(user.getId(), cardTopic.getOrdinal(), Constants.SEEN_CARDS_SIZE);

        resultCollection.addAll(newCards);
        resultCollection.addAll(seenCards);
        resultCollection = resultCollection.stream().limit(Constants.SAMPLE_SIZE).collect(Collectors.toList());

        return resultCollection;
    }

    public Statistics getStatistics() {
        log.info("Get full statistics in percentage");
        Integer allSeenVocabulary = cardRepository.findAllSeenByCardTopic(CardTopic.VOCABULARY.getOrdinal());
        Integer allSeenIdioms = cardRepository.findAllSeenByCardTopic(CardTopic.IDIOMS.getOrdinal());

        long allVocabulary = cardRepository.countByCardTopic(CardTopic.VOCABULARY);
        long allIdioms = cardRepository.countByCardTopic(CardTopic.IDIOMS);

        DecimalFormat df = new DecimalFormat("##.##");

        Double percentageHealth = new Double(df.format((double)allSeenVocabulary/allVocabulary));
        Double percentageTravel = new Double(df.format((double)allSeenIdioms/allIdioms));

        return Statistics.builder()
                .healthPercentage(percentageHealth)
                .travelPercentage(percentageTravel)
                .build();
    }
}
