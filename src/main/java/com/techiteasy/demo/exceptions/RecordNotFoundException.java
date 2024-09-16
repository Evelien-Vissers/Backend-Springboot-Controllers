package com.techiteasy.demo.exceptions;

// Deze exceptionklasse wordt gebruikt in de TelevisionController wanneer een bepaalde tv niet wordt gevonden
// Het geeft zowel een default constructor als een constructor met een message.

// Extends RunTimeException
public class RecordNotFoundException extends RuntimeException {

    //Default exception
    public RecordNotFoundException() {
        super("Record not found");
    }
    //Exception met een message
    public RecordNotFoundException(String message) {
        super(message);
    }
}
