package org.yaremax.hackathon8_task_24_04_2024.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaremax.hackathon8_task_24_04_2024.exceptions.ResourceNotFoundException;
import org.yaremax.hackathon8_task_24_04_2024.models.category.Category;
import org.yaremax.hackathon8_task_24_04_2024.models.category.CategoryRepository;
import org.yaremax.hackathon8_task_24_04_2024.models.tag.Tag;
import org.yaremax.hackathon8_task_24_04_2024.models.tag.TagRepository;
import org.yaremax.hackathon8_task_24_04_2024.models.user.UserEntity;
import org.yaremax.hackathon8_task_24_04_2024.models.user.UserRepository;

@Service
@AllArgsConstructor
public class ReferenceService {
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;

    public UserEntity getUserReferenceById(Long id) {
        return userRepository.getReferenceById(id);
    }

    public UserEntity getUserReferenceByEmail(String email) {

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("ніц"));
        return userRepository.getReferenceById(user.getId());
    }

    public Tag getTagReferenceById(Long id) {
        return tagRepository.getReferenceById(id);
    }

    public Category getCategoryReferenceById(Long id) {
        return categoryRepository.getReferenceById(id);
    }
}
