package org.nexttech.exceptions;

public class StudentNotDeletedException extends RuntimeException {

    public StudentNotDeletedException(String message) {
        super(message);
    }
}