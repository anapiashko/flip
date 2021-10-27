package com.app.flip.dao;

import com.app.flip.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

  Optional<Card> findById(Integer id);

//  @Query(value = "SELECT c FROM Card c " +
//          "JOIN Progress p ON c.id = p.cardId  WHERE c.cardTopic = :cardTopic AND p.probability < 1")
//  List<Card> findByCardTopic(@Param("cardTopic") CardTopic cardTopic, PageRequest pageRequest);

  @Query(value = "(SELECT c.id, c.en_sentence, c.rus_sentence, c.missed_word, c.topic FROM card c WHERE c.topic = :cardTopic LIMIT 10)" +
          " UNION " +
          "(SELECT c.id, c.en_sentence, c.rus_sentence, c.missed_word, c.topic FROM card c WHERE c.topic = :cardTopic LIMIT 5)",
          nativeQuery = true)
  List<Card> findByCardTopic(@Param("cardTopic") String cardTopic);

}
