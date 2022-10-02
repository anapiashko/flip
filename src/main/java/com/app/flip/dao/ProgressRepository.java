package com.app.flip.dao;

import com.app.flip.model.Progress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends CrudRepository<Progress, Integer> {

    @Query("select p from Progress p " +
            "join User u on p.userId=u.id where u.email=:email and p.cardId=:cardId")
    Progress findByCardIdAndUserEmail(Integer cardId, String email);
}