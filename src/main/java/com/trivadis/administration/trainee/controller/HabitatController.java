package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.entities.Habitat;
import com.trivadis.administration.trainee.service.HabitatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habitat")
public class HabitatController {

    private HabitatService habitatService;

    public HabitatController(HabitatService habitatService) {
        this.habitatService = habitatService;
    }

    @PostMapping
    public Habitat saveHabitat(@RequestBody Habitat habitat) {
        return this.habitatService.saveHabitat(habitat);
    }

    @GetMapping
    public Iterable<Habitat> getAllHabitats() {
        return this.habitatService.getAllHabitats();
    }

    @GetMapping("/{habitatId}")
    public Habitat getHabitatById(@PathVariable Long habitatId) {
        return this.habitatService.getHabitatById(habitatId);
    }
}
