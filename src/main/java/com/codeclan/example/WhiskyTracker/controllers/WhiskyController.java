package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public List<Whisky> getAllWhiskies() {
        return whiskyRepository.findAll();
    }

    @GetMapping(value = "/distilleries/{distillery}/aged/{age}")
    public List<Whisky> findDistilleryThatHaveWhiskyAged(@PathVariable Long id, @PathVariable int age) {
        return whiskyRepository.findDistilleryThatHaveWhiskyAged(id, age);
    }

    @GetMapping(value = "/distilleries/location/{region}")
    public List<Whisky> findAllWhiskyByRegion(@PathVariable String region) {
        return whiskyRepository.findAllWhiskyByRegion(region);
    }

}
