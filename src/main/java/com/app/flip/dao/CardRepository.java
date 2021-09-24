package com.app.flip.dao;

import com.app.flip.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

  Optional<Card> findById(Integer id);

}
