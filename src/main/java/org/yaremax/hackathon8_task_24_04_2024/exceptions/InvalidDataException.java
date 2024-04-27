package org.yaremax.hackathon8_task_24_04_2024.exceptions;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super("(InvalidDataException) " + message);
    }
}
