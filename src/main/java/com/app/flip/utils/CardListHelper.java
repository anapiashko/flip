package com.app.flip.utils;

import com.app.flip.model.Card;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public final class CardListHelper {

    private static final Integer MAX_SEN_SIZE = 10;
    private static final Integer MIN_SEN_SIZE = 4;

    private static List<Card> newCards = new ArrayList<>();

    private CardListHelper() {
    }

    public static CardListHelper getInstance(List<Card> cards) {
        newCards = CardListHelper.clone(cards);
        return new CardListHelper();
    }

    public CardListHelper removeEmptyCards() {
        List<Card> temp = new ArrayList<>();

        for (Card card : newCards) {
            if (StringUtils.isNotBlank(card.getEnglishSentence()) &&
                    StringUtils.isNotBlank(card.getRussianSentence())) {
                temp.add(card);
            }
        }
        newCards = temp;
        return this;
    }

    public CardListHelper getCardsWithAverageSize() {
        List<Card> temp = new ArrayList<>();

        for (Card card : newCards) {
            int cardLength = card.getEnglishSentence().split(" ").length;
            if (cardLength >= MIN_SEN_SIZE && cardLength <= MAX_SEN_SIZE) {
                temp.add(card);
            }
        }
        newCards = temp;
        return this;
    }

    public List<Card> collect() {
        return newCards;
    }

    public static List<Card> clone(List<Card> cards) {
        List<Card> temp = new ArrayList<>();
        for (Card card : cards) {
            temp.add(new Card(card.getId(), card.getEnglishSentence(), card.getRussianSentence()));
        }
        return temp;
    }
}
