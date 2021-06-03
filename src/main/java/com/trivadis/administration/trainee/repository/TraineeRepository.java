package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Trainee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends CrudRepository<Trainee,Long> {
}
