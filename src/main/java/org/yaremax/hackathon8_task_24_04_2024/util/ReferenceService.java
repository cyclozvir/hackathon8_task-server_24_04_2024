package org.yaremax.hackathon8_task_24_04_2024.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaremax.hackathon8_task_24_04_2024.user.UserEntity;
import org.yaremax.hackathon8_task_24_04_2024.user.UserRepository;

@Service
@AllArgsConstructor
public class ReferenceService {
    private final UserRepository userRepository;

    public UserEntity getUserReferenceById(Long id) {
        return userRepository.getReferenceById(id);
    }
}
