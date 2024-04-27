package org.yaremax.hackathon8_task_24_04_2024.exceptions;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
        super("(DuplicateResourceException) " + message);
    }
}
