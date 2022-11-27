package com.app.flip.controllers;

import com.app.flip.model.Card;
import com.app.flip.model.Statistics;
import com.app.flip.model.User;
import com.app.flip.services.CardServiceImpl;
import com.app.flip.model.CardTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CardController {

    @Autowired
    private CardServiceImpl cardService;

    @PostMapping("/get-sample")
    public List<Card> getSampleByTopic(@RequestParam String topic, @RequestBody User user) {
        log.info("Get card sample by topic name, topic = {}", topic);
        List<Card> sample = cardService.getSample(CardTopic.valueOf(topic.toUpperCase()), user);
        return sample;
    }

    @GetMapping("/get-statistics")
    public Statistics getStatistics() {
        log.info("Get Statistics");
        return cardService.getStatistics();
    }
}
