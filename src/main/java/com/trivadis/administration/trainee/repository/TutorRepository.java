package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Tutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends CrudRepository<Tutor,Long> {
}
