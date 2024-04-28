package org.yaremax.hackathon8_task_24_04_2024.models.image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.yaremax.hackathon8_task_24_04_2024.exceptions.ResourceNotFoundException;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public byte[] getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find image with id: " + id))
                .getContent();
    }

    public void addImage(MultipartFile multipartImage, String category) throws IOException {
        Image image = Image.builder()
                .name(multipartImage.getName())
                .content(multipartImage.getBytes())
                .category(category)
                .build();

        imageRepository.save(image);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    public List<Image> getImagesByCategory(String category) {
        return imageRepository.getImagesByCategory(category);
    }


}
