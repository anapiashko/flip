package com.app.flip.utils;

import com.app.flip.model.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardListHelperTest {

    @Test
    public void testFilteringCardList(){
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1,"Breakfast is very important","Завтрак важен"));
        cardList.add(new Card(2,"",""));
        cardList.add(new Card(3,"Breakfast is super very important to eat every day before starting your new day","Завтрак важен"));
        cardList.add(new Card(4,"","Завтрак важен"));
        cardList.add(new Card(5,"Breakfast is important",""));

        List<Card> resultCardList = CardListHelper.getInstance(cardList)
                .removeEmptyCards()
                .getCardsWithAverageSize()
                .collect();

        assertEquals(1, resultCardList.size());
        assertEquals(1, resultCardList.get(0).getId());
        assertEquals("Breakfast is very important", resultCardList.get(0).getEnglishSentence());
        assertEquals("Завтрак важен", resultCardList.get(0).getRussianSentence());
    }

}