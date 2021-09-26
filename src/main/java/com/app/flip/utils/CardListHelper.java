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

    public CardListHelper setMissedWord() {
        List<Card> temp = new ArrayList<>();

        for (Card card : newCards) {

            if (StringUtils.isNotBlank(card.getEnglishSentence()) && card.getMissedWord() == null) {

                String[] words = card.getEnglishSentence().split(" ");
                int cardLength = words.length;
                boolean[] wordWasChosenByRand = new boolean[cardLength];
                while (atLeastOneIsFalse(wordWasChosenByRand)) {
                    int rand = getRandomNumber(cardLength);
                    String word = words[rand];
                    if (word.length() <= MIN_SEN_SIZE) {
                        wordWasChosenByRand[rand] = true;
                    } else {
                        card.setMissedWord(rand);
                        temp.add(card);
                        break;
                    }
                }
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
            String trimmedEnSen = card.getEnglishSentence().trim().replaceAll("\\s{2,}", " ");
            temp.add(new Card(card.getId(), trimmedEnSen, card.getRussianSentence()));
        }
        return temp;
    }

    private int getRandomNumber(int max) {
        return (int) (Math.random() * max);
    }

    private boolean atLeastOneIsFalse(boolean[] array) {
        boolean val = true;
        for (boolean b : array) {
            val = val && b;
        }
        return !val;
    }
}
