package com.app.flip.dao;

import com.app.flip.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

  Optional<Card> findById(Integer id);

  @Query(value = "SELECT c.id, c.en_sentence, c.rus_sentence, c.missed_word, c.topic FROM card c " +
          " JOIN progress p on c.id = p.card_id WHERE c.topic = :cardTopic AND p.probability = 1 LIMIT :limitValue",
          nativeQuery = true)
  List<Card> findNewByCardTopic(@Param("cardTopic") String cardTopic, Integer limitValue);

  @Query(value = "SELECT c.id, c.en_sentence, c.rus_sentence, c.missed_word, c.topic FROM card c " +
          " JOIN progress p on c.id = p.card_id WHERE c.topic = :cardTopic AND p.probability < 1 LIMIT :limitValue",
          nativeQuery = true)
  List<Card> findSeenByCardTopic(@Param("cardTopic") String cardTopic,  Integer limitValue);

}
