package com.app.flip.services;

import com.app.flip.model.Card;

import java.util.List;

public interface CardService {

    List<Card> saveAll(List<Card> cards);

}
