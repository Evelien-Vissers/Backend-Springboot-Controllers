package com.techiteasy.demo.controllers;

import com.techiteasy.demo.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Deze klasse behandelt uitzonderingen (zoals de RecordNotFoundException)
@Controller // Stap 5: voorzie deze klasse van de juiste annotatie
public class ExceptionController {

    // ExceptionHandler voor RecordNotFoundException
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
    // ExceptionHandler voor algemene RuntimeExceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(500).body("An error occurred: " + ex.getMessage());
    }
}
