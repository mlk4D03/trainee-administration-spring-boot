package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Year;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends CrudRepository<Year,Long> {
}
