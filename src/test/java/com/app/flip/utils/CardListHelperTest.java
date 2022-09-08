package com.app.flip.utils;

import com.app.flip.model.Card;
import com.app.flip.model.CardTopic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardListHelperTest {

    @Test
    public void testFilteringCardList(){
        // given
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1,"Breakfast is very important","Завтрак очень важен", 0,
                CardTopic.HEALTH, "media/1001.mp3"));
        cardList.add(new Card(2,"","", null, null, "media/1001.mp3"));
        cardList.add(new Card(3,"Breakfast is super very important to eat every day before starting your new day","Завтрак важен", 0,
                CardTopic.HEALTH, "media/1001.mp3"));
        cardList.add(new Card(4,"","Завтрак важен.", null, CardTopic.HEALTH, "media/1001.mp3"));
        cardList.add(new Card(5,"Breakfast is important.","", 0, CardTopic.HEALTH, "media/1001.mp3"));
        cardList.add(new Card(6," Did you get    any breakfast?  "," Ты позавтракал?", 4,
                CardTopic.HEALTH, "media/1001.mp3"));

        // when
        List<Card> resultCardList = CardListHelper.getInstance(cardList)
                .removeEmptyCards()
                .getCardsWithAverageSize()
                .setPunctuation()
                .collect();

        // then
        assertEquals(2, resultCardList.size());
        assertEquals(1, resultCardList.get(0).getId());
        assertEquals("Breakfast is very important.", resultCardList.get(0).getEnglishSentence());
        assertEquals("Завтрак очень важен.", resultCardList.get(0).getRussianSentence());

        assertEquals(6, resultCardList.get(1).getId());
        assertEquals("Did you get any breakfast?", resultCardList.get(1).getEnglishSentence());
        assertEquals("Ты позавтракал?", resultCardList.get(1).getRussianSentence());
    }

    @Test
    public void testChoosingMissedWordForCardList(){
        // given
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1,"Breakfast is very good","Завтрак хорош",0, CardTopic.HEALTH, "media/1001.mp3"));
        cardList.add(new Card(2,"","", null, null, "media/1001.mp3"));
        cardList.add(new Card(3,"I am not tall","Я не высокий", null,null, "media/1001.mp3"));
        cardList.add(new Card(4,"  Ask you be   careful with it ","Прошу, будь осторожен", 3,
                CardTopic.TRAVEL, "media/1001.mp3"));

        // when
        List<Card> resultCardList = CardListHelper.getInstance(cardList)
                .setMissedWord()
                .collect();

        // then
        assertEquals(2, resultCardList.size());

        Integer missedBreakfastWord = resultCardList.get(0).getMissedWord();
        assertNotNull(missedBreakfastWord);
        assertEquals(0, missedBreakfastWord);

        Integer missedCarefulWord = resultCardList.get(1).getMissedWord();
        assertNotNull(missedCarefulWord);
        assertEquals(3, missedCarefulWord);
    }

}