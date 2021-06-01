package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.entities.Habitat;
import com.trivadis.administration.trainee.repository.HabitatRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class HabitatService {

    private HabitatRepository habitatRepository;

    public HabitatService(HabitatRepository habitatRepository) {
        this.habitatRepository = habitatRepository;
    }

    public Habitat saveHabitat(Habitat habitat) {
        return this.habitatRepository.save(habitat);
    }

    public Iterable<Habitat> getAllHabitats() {
        return this.habitatRepository.findAll();
    }

    public Habitat getHabitatById(Long id) {
        Optional<Habitat> habitatOptional = this.habitatRepository.findById(id);
        if(habitatOptional.isPresent()) {
            return habitatOptional.get();
        } else {
            return null;
        }
    }
}
