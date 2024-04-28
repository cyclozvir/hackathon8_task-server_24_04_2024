package org.yaremax.hackathon8_task_24_04_2024.models.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaremax.hackathon8_task_24_04_2024.models.category.Category;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image getImageByCategory(Category category);
}
