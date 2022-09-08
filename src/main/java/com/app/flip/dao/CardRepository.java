package com.app.flip.dao;

import com.app.flip.model.Card;
import com.app.flip.model.CardTopic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

  Optional<Card> findById(Integer id);

  long countByCardTopic(CardTopic cardTopic);

  @Query(value = "SELECT c.id, c.en_sentence, c.rus_sentence, c.missed_word, c.topic, c.location FROM card c " +
          " JOIN progress p on c.id = p.card_id WHERE c.topic = :cardTopic AND p.probability = 1 LIMIT :limitValue",
          nativeQuery = true)
  List<Card> findNewByCardTopic(@Param("cardTopic") Integer cardTopic, Integer limitValue);

  @Query(value = "SELECT c.id, c.en_sentence, c.rus_sentence, c.missed_word, c.topic, c.location FROM card c " +
          " JOIN progress p on c.id = p.card_id WHERE c.topic = :cardTopic AND p.probability BETWEEN 0.1 AND 0.9 LIMIT :limitValue",
          nativeQuery = true)
  List<Card> findSeenByCardTopic(@Param("cardTopic") Integer cardTopic, Integer limitValue);

  @Query(value = "SELECT count(c.id) FROM card c " +
          " JOIN progress p on c.id = p.card_id WHERE c.topic = :cardTopic AND p.probability < 1",
          nativeQuery = true)
  Integer findAllSeenByCardTopic(@Param("cardTopic") Integer cardTopic);

}
