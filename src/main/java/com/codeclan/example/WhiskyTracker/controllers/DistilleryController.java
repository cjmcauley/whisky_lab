package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {
    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping
    public List<Distillery> getAllDistilleries() {
        return distilleryRepository.findAll();
    }

    @GetMapping(value = "/whiskies/aged/{age}")
    public List<Distillery> findDistilleriesWithWiskiesAged(@PathVariable int age) {
        return distilleryRepository.findDistilleryThatHasWhiskyAged(age);
    }

}
