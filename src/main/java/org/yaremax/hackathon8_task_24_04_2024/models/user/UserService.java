package org.yaremax.hackathon8_task_24_04_2024.models.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaremax.hackathon8_task_24_04_2024.exceptions.DuplicateResourceException;
import org.yaremax.hackathon8_task_24_04_2024.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " wasn't found"));
    }

    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " wasn't found"));
    }

    @Transactional
    public void addUser(UserEntity user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateResourceException("User with email " + user.getEmail() + " already exists");
        }
        userRepository.save(user);
    }
}
