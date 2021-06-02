package com.trivadis.administration.trainee.repository;

import com.trivadis.administration.trainee.entities.Module;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<Module,Long> {
}
