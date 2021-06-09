package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,Long> {
}
