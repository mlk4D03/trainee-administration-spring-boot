package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {
}
