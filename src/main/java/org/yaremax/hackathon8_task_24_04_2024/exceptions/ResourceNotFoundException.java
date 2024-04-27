package org.yaremax.hackathon8_task_24_04_2024.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super("(ResourceNotFoundException) " + message);
    }
}
