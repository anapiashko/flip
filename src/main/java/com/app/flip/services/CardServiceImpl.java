package com.app.flip.services;

import com.app.flip.dao.CardRepository;
import com.app.flip.model.Card;
import com.app.flip.model.Progress;
import com.app.flip.model.Statistics;
import com.app.flip.utils.CardTopic;
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

    public List<Card> getSample(CardTopic cardTopic) {
        log.info("Getting sample by topic = {}", cardTopic);

        List<Card> resultCollection = new ArrayList<>();

        List<Card> newCards = cardRepository.findNewByCardTopic(cardTopic.getOrdinal(), Constants.NEW_CARDS_SIZE);
        List<Card> seenCards = cardRepository.findSeenByCardTopic(cardTopic.getOrdinal(), Constants.SEEN_CARDS_SIZE);

        if (seenCards.size() < Constants.SEEN_CARDS_SIZE) {
            newCards.addAll(cardRepository.findNewByCardTopic(cardTopic.getOrdinal(), Constants.SEEN_CARDS_SIZE));
            newCards = newCards.stream().distinct().collect(Collectors.toList());
        }

        resultCollection.addAll(newCards);
        resultCollection.addAll(seenCards);
        resultCollection = resultCollection.stream().limit(Constants.SAMPLE_SIZE).collect(Collectors.toList());

        return resultCollection;
    }

    public Statistics getStatistics() {
        log.info("Get full statistics in percentage");
        Integer allSeenHealth = cardRepository.findAllSeenByCardTopic(CardTopic.HEALTH.getOrdinal());
        Integer allSeenTravel = cardRepository.findAllSeenByCardTopic(CardTopic.TRAVEL.getOrdinal());

        long allHealth = cardRepository.countByCardTopic(CardTopic.HEALTH);
        long allTravel = cardRepository.countByCardTopic(CardTopic.TRAVEL);

        DecimalFormat df = new DecimalFormat("##.##");

        Double percentageHealth = new Double(df.format((double)allSeenHealth/allHealth));
        Double percentageTravel = new Double(df.format((double)allSeenTravel/allTravel));

        return Statistics.builder()
                .healthPercentage(percentageHealth)
                .travelPercentage(percentageTravel)
                .build();
    }
}
