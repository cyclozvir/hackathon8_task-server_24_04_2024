package org.yaremax.hackathon8_task_24_04_2024.models.image;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> getImagesByCategory(String category);
}
