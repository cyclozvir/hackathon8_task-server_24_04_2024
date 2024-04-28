package org.yaremax.hackathon8_task_24_04_2024.security.auth.records;

public record RegisterRequest(String firstName,
                              String lastName,
                              String email,
                              String password) {
}
