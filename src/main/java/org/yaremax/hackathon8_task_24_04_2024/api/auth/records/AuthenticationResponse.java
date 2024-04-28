package org.yaremax.hackathon8_task_24_04_2024.api.auth.records;

import org.yaremax.hackathon8_task_24_04_2024.user.Role;

public record AuthenticationResponse(String token,
                                     Role role) {
}
