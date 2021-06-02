package com.trivadis.administration.trainee.service;

import com.trivadis.administration.trainee.entities.Year;
import com.trivadis.administration.trainee.repository.YearRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class YearService {

    YearRepository yearRepository;

    public YearService(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }

    public Year saveYear(Year year) {
        return this.yearRepository.save(year);
    }

    public Iterable<Year> getAllYears() {
        return this.yearRepository.findAll();
    }
}
