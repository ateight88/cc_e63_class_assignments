package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repository.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;


    @GetMapping(value = "/pirates")
    public ResponseEntity<List<Pirate>> getAllPirates(){
        return new ResponseEntity<>(pirateRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/pirates/{id}")
    public ResponseEntity getPirate(@PathVariable Long id){
        return new ResponseEntity<>(pirateRepository.findById(id), HttpStatus.OK);
    }

}
