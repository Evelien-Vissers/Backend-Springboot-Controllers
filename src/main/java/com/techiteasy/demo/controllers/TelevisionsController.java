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

//Deze klasse bevat alle gevraagde CRUD-endpoints
public class TelevisionsController {

    //Deze mock is een tijdelijke oplossing om data in het geheugen op te slaan, zodat de functionaliteit van de controller getest kan worden zonder een database of externe opslag te gebruiken. De 'Map<Long, String> is hier gebruikt als een soort van database.
    //De Map<Long, String> is een Java Map die tv-gegevens opslaat - het gebruikt een 'Long' als sleutel (= het ID van de tv) en een String als waarde (= details van de tv).
    //De 'new HashMap<>()' maakt een lege HashMap aan, die je kan gebruiken om tv's op te slaan.
    private final Map<Long, String> televisions = new HashMap<>(); //Ik heb dit 'final' gemaakt om duidelijk te maken dat de referentie naar het Map-object onveranderlijk is na initiele toewijzing (oa voor betere leesbaarheid van de code en het evt. per ongeluk her-toewijzen van het veld elders in de code).

    //Stap 3: Voeg requests toe met ResponseEntity
    // GET - request voor alle televisies
    @GetMapping
    public ResponseEntity<List<String>> getAllTelevisions() {
        return ResponseEntity.ok(new ArrayList<>(televisions.values())); //hier worden alle waarden (details van tv's uit de 'Map' gehaald met 'televeision.values()' en omgezet in een ArrayList. Dit geeft een lijst van tv's terug.
    }
    // GET - request voor 1 televisie
    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable Long id) {
        String television = televisions.get(id); //Dit zoekt naar de tv met het opgegeven 'id' in de 'Map'. Wanneer deze niet bestaat, krijg je 'null' terug (wat wordt afgehandeld met een exception).
        if (television == null) {
            throw new RecordNotFoundException("Television not found with ID: " + id);
        }
        return ResponseEntity.ok(television);
    }
    // POST - request voor het aanmaken van 1 televisie
    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String televisionDetails) {
        long id = televisions.size() + 1; //Hier wordt een nieuw 'id' gegenereerd door de grootte van de 'Map' te nemen en er 1 bij op te tellen.
        televisions.put(id, televisionDetails); //Hier wordt de nieuwe tv toegevoegd aan de 'Map' met dit nieuwe id.
        return ResponseEntity.status(201).body("Television created: " + id);
}

    // PUT-request voor het updaten van 1 tv
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable Long id, @RequestBody String updatedTelevisionDetails) {
        if (!televisions.containsKey(id)) {
            throw new RecordNotFoundException("Television not found with ID: " + id);
        }
        televisions.put(id, updatedTelevisionDetails); //Dit vervangt de bestaande tv met het opgegeven 'id' door de nieuwe gegevens in de 'Map'
        return ResponseEntity.ok("Television updated with ID: " + id);
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
