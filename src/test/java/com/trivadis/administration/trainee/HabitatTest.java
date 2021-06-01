package com.trivadis.administration.trainee;

import com.trivadis.administration.trainee.entities.Habitat;
import com.trivadis.administration.trainee.service.HabitatService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
public class HabitatTest {

    @Autowired
    HabitatService habitatService;

    @Test
    void saveHabitat() {
        Habitat habitat = new Habitat();
        habitat.setCity("Hamburg");
        habitat.setStreet("Paul-Dessau-Straße 6");
        habitat.setZip(20089);

        Habitat answer = habitatService.saveHabitat(habitat);
        Assertions.assertNotNull(answer);
    }

    @Test
    void getAllHabitats() {
        Habitat habitat = new Habitat();
        habitat.setCity("Hamburg");
        habitat.setStreet("Paul-Dessau-Straße 6");
        habitat.setZip(20089);

        habitatService.saveHabitat(habitat);

        Iterable<Habitat> habitats = habitatService.getAllHabitats();

        Assertions.assertEquals(1,((Collection<Habitat>) habitats).size());

    }

    @Test
    void getAllHabitatsById() {
        Habitat habitat = new Habitat();
        habitat.setCity("Hamburg");
        habitat.setStreet("Paul-Dessau-Straße 6");
        habitat.setZip(20089);

        habitatService.saveHabitat(habitat);

        Habitat habitatAnswer = habitatService.getHabitatById(1L);

        Assertions.assertNotNull(habitatAnswer);

    }

}
