package org.yaremax.hackathon8_task_24_04_2024.models.category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@Api(tags = "Category Management")
public class CategoryController {
    private final CategoryService categoryService;

    @ApiOperation(value = "Створити категорію", notes = "Створює нову категорію")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Категорія успішно створена"),
            @ApiResponse(code = 400, message = "Неправильний запит")
    })
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @ApiOperation(value = "Отримати всі категорії", notes = "Повертає список всіх категорій")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успішно повернуто список категорій"),
            @ApiResponse(code = 404, message = "Категорії не знайдено")
    })
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}

