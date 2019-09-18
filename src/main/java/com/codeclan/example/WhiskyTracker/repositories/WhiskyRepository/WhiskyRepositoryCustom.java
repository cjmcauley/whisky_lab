package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> findAllWhiskyByRegion(String region);

    List<Whisky> findDistilleryThatHaveWhiskyAged(long id, int age);

}
