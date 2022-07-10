package com.app.flip.controllers;

import com.app.flip.model.Card;
import com.app.flip.model.Statistics;
import com.app.flip.services.CardServiceImpl;
import com.app.flip.utils.CardTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class CardController {

    @Autowired
    private CardServiceImpl cardService;

    @GetMapping("/get-sample")
    public List<Card> getSampleByTopic(@RequestParam String topic) {
        log.info("Get card sample by topic name, topic = {}", topic);
        List<Card> sample = cardService.getSample(CardTopic.valueOf(topic.toUpperCase()));
        return sample;
    }

    @GetMapping("/get-statistics")
    public Statistics getStatistics() {
        log.info("Get Statistics");
        return cardService.getStatistics();
//        return new ArrayList<>(Arrays.asList(new Card(190, "Eat fruits, vegetables and whole grains.", "Ешьте фрукты, овощи и цельнозерновые продукты.", 0, CardTopic.fromString(topic)),
//                new Card(2, "When you can enjoy them, you feel relaxed and rejuvenated.", "Я тебя не знаю", 2, CardTopic.fromString(topic))));
    }
}
