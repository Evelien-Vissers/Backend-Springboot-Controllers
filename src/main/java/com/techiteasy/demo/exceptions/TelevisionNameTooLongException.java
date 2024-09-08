package com.techiteasy.demo.exceptions;

public class TelevisionNameTooLongException extends RuntimeException {
    public TelevisionNameTooLongException(String message) {
        super(message);
    }
}
