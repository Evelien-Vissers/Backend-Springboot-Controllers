package com.techiteasy.demo.controllers;

import com.techiteasy.demo.exceptions.RecordNotFoundException;
import com.techiteasy.demo.exceptions.TelevisionNameTooLongException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Deze klasse behandelt uitzonderingen en aangepaste foutafhandeling voor specifieke situaties (zoals de RecordNotFoundException)

@ControllerAdvice // Stap 5: voorzie deze klasse van de juiste annotatie
//Notitie van MR: Deze exception is een 'ControllerAdvice' ipv '@Controller', omdat het een helper is voor de controllers (en geen echte controller)
//Er staan namelijk geen endpoints in die een gebruiker direct kan aanspreken.
public class ExceptionController {

    // ExceptionHandler voor RecordNotFoundException
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
    @ExceptionHandler(TelevisionNameTooLongException.class)
    //public ResponseEntity<String> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
    public ResponseEntity<String> handleTelevisionNameTooLongException(TelevisionNameTooLongException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }
    //Notitie van MR: ipv ".status(404)" kan je ook ".notFound()" gebruiken met nog een message.

}
