package org.yaremax.hackathon8_task_24_04_2024.models.image;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@Api(tags = "Image Management")
public class ImageController {
    private final ImageService imageService;

    @ApiOperation(value = "Завантажити зображення", notes = "Завантажує зображення на сервер")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Зображення успішно завантажене"),
            @ApiResponse(code = 400, message = "Неправильний запит")
    })
    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("multipartImage") MultipartFile multipartImage,
                                              @RequestParam(value = "category_id", required = false) Long categoryId) throws Exception {
        imageService.addImage(multipartImage, categoryId);
        return ResponseEntity.ok("Success");
    }

    @ApiOperation(value = "Отримати зображення за категорією", notes = "Повертає зображення за заданою категорією")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успішно повернуто зображення"),
            @ApiResponse(code = 404, message = "Зображення не знайдено")
    })
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getImageByCategory(@RequestParam(value = "category_id", required = false) Long categoryId) {
        byte[] imageBytes = imageService.getImageByCategory(categoryId);
        return new ByteArrayResource(imageBytes);
    }
}
