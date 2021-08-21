package com.app.flip.dao;

import com.app.flip.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CardRepository extends MongoRepository<Card, Integer> {

  Optional<Card> findById(Integer id);
}
