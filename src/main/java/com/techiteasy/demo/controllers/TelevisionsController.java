package com.techiteasy.demo.controllers;

import com.techiteasy.demo.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
//Controllers bevatten de endpoints en zijn verantwoordelijk voor het afhandelen van inkomende HTTP-verzoeken

//Stap 2: voorzie de klasse van de juiste annotatie
@RestController
@RequestMapping("/televisions")
//Notitie MR: RequestMapping heeft an sich geen toegevoegde waarde. Als je echter ("/televisions") erachter invult, dan komt jouw "getAllTelevisions" op het pad "localhost:8080/televisions" (ipv alleen op "localhost:8080"). [Daarom nu "/televisions" erachter gezet.

//Deze klasse bevat alle gevraagde CRUD-endpoints
public class TelevisionsController {

    //Deze mock is een tijdelijke oplossing om data in het geheugen op te slaan, zodat de functionaliteit van de controller getest kan worden zonder een database of externe opslag te gebruiken.
    private final List<String> televisionDataBase = new ArrayList<>(Arrays.asList("Samsung", "Sony", "LG")); //Ik heb dit 'final' gemaakt om duidelijk te maken dat de referentie naar het Map-object onveranderlijk is na initiele toewijzing (oa voor betere leesbaarheid van de code en het evt. per ongeluk her-toewijzen van het veld elders in de code).

    //Stap 3: Voeg requests toe met ResponseEntity
    // GET - request voor alle televisies
    @GetMapping
    public ResponseEntity<List<String>> getAllTelevisions() {
        return ResponseEntity.ok(televisionDataBase); //hier worden alle waarden (details van tv's uit de 'Map' gehaald met 'televeision.values()' en omgezet in een ArrayList. Dit geeft een lijst van tv's terug - ResponseEntity.ok voor lijst van tv's
    }

    // GET - request voor 1 televisie
    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable int id) {
        //String television = televisionDataBase.get(id); //Dit zoekt naar de tv met het opgegeven 'id'. Wanneer deze niet bestaat, krijg je 'null' terug (wat wordt afgehandeld met een exception).
        if (id < 0 || id > televisionDataBase.size() || televisionDataBase.get(id) == null) {
            throw new RecordNotFoundException("Television not found with ID: " + id);
        }
        String television = televisionDataBase.get(id);
        return ResponseEntity.ok(television); //ResponseEntity.ok voor individuele tv
    }

    // POST - request voor het aanmaken van 1 televisie
    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String televisionDetails) {
        if (televisionDetails.length() > 20) {
            throw new TelevisionNameTooLongException("Television name exceeds the maximum length of 20 characters");
        }
        televisionDataBase.add(televisionDetails);
        return ResponseEntity.created(null).body("Television added: " + televisionDetails); //ResponseEntity.created bij succesvolle creatie
    }

    // PUT-request voor het updaten van 1 tv
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String updatedTelevisionDetails) {
        if (id < 0 || id >= televisionDataBase.size() || televisionDataBase.get(id) == null) {
            throw new RecordNotFoundException("Television not found with ID: " + id);
        }
        televisionDataBase.set(id, updatedTelevisionDetails);
        return ResponseEntity.ok().body("Television updated at index " + id + ": " + updatedTelevisionDetails);
    }

    // DELETE - request voor het verwijderen van 1 televisie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable int id) {
        if (id < 0 || id >= televisionDataBase.size() || televisionDataBase.get(id) == null) {
           throw new RecordNotFoundException("Television not found with ID: " + id);
        }
        televisionDataBase.set(id, null); //Notitie MR: idd goed om hier .set(id, null) te gebruiken ipv .remove(id) - dat zou namelijk de volgorde van je lijst veranderen en dus elke tv een nieuwe id geven - dat kan in een database niet.
        return ResponseEntity.noContent().build();
    }
}
