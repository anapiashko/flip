package com.app.flip.dao;

import com.app.flip.model.Progress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends CrudRepository<Progress, Integer> {

    Progress findByCardId(Integer cardId);
}