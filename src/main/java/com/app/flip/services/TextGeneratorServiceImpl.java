package com.app.flip.services;

import com.app.flip.model.Card;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TextGeneratorServiceImpl {

    private final RestTemplate restTemplate;

    public TextGeneratorServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Card> getText() {
        return Arrays.asList(
                Objects.requireNonNull(
                        restTemplate.getForObject("http://localhost:5000/analyze?title=health", Card[].class)
                ));
    }
}
