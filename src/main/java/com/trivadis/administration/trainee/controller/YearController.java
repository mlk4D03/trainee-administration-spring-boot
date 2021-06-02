package com.trivadis.administration.trainee.controller;

import com.trivadis.administration.trainee.entities.Year;
import com.trivadis.administration.trainee.service.YearService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/year")
public class YearController {

    YearService yearService;

    public YearController(YearService yearService) {
        this.yearService = yearService;
    }

    @PostMapping
    public Year saveYear(@RequestBody Year year) {
        return this.yearService.saveYear(year);
    }

    @GetMapping("/allYears")
    public Iterable<Year> getAllYears() {
        return  this.yearService.getAllYears();
    }
}
