package org.yaremax.hackathon8_task_24_04_2024.models.image;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api/v1/images")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam MultipartFile multipartImage,
                                            @RequestParam(required = false) String category) throws Exception {
        imageService.addImage(multipartImage, category);
        return ResponseEntity.ok("Success");
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource downloadImage(@PathVariable Long id) {
        return new ByteArrayResource(imageService.getImageById(id));
    }

    @GetMapping
    public ResponseEntity<List<Image>> getImages(@RequestParam(required = false) String category) throws Exception {
        if (category != null) return ResponseEntity.ok(imageService.getImagesByCategory(category));
        else return ResponseEntity.ok(imageService.getImages());
    }
}
