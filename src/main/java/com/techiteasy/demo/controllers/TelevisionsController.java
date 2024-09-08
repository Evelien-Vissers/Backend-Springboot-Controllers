package com.techiteasy.demo.controllers;

import com.techiteasy.demo.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Stap 2: voorzie de klasse van de juiste annotatie
@RestController
@RequestMapping

public class TelevisionsController {

    private Map<Long, String> televisions = new HashMap<>();

    //Stap 3: Voeg requests toe met ResponseEntity
    // GET - request voor alle televisies
    @GetMapping
    public ResponseEntity<List<String>> getAllTelevisions() {
        return ResponseEntity.ok(new ArrayList<>(televisions.values()));
    }
    // GET - request voor 1 televisie
    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable Long id) {
        String television = televisions.get(id);
        if (television == null) {
            throw new RecordNotFoundException("Television not found with ID: " + id);
        }
        return ResponseEntity.ok(television);
    }
    // POST - request voor het aanmaken van 1 televisie
    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String televisionDetails) {
        long id = televisions.size() + 1;
        televisions.put(id, televisionDetails);
        return ResponseEntity.status(201).body("Television created: " + id);
}
    // DELETE - request voor het verwijderen van 1 televisie
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        if (!televisions.containsKey(id)) {
            throw new RecordNotFoundException("Television not found with ID: " + id);
        }
        televisions.remove(id);
        return ResponseEntity.noContent().build();

}
}
