package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Habitat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends CrudRepository<Habitat, Long> {
}
