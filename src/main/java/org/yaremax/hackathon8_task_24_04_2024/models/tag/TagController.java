package org.yaremax.hackathon8_task_24_04_2024.models.tag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@Api(tags = "Tag Management")
public class TagController {
    private final TagService tagService;

    @ApiOperation(value = "Створити мітку", notes = "Створює нову мітку")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Мітка успішно створена"),
            @ApiResponse(code = 400, message = "Неправильний запит")
    })
    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.createTag(tag));
    }

    @ApiOperation(value = "Отримати всі мітки", notes = "Повертає список всіх міток")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успішно повернуто список міток"),
            @ApiResponse(code = 404, message = "Мітки не знайдено")
    })
    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }
}
