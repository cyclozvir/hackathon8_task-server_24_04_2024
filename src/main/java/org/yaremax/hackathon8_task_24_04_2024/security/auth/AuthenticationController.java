package org.yaremax.hackathon8_task_24_04_2024.security.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaremax.hackathon8_task_24_04_2024.security.auth.records.RegisterRequest;
import org.yaremax.hackathon8_task_24_04_2024.security.auth.records.AuthenticationResponse;
import org.yaremax.hackathon8_task_24_04_2024.security.auth.records.LoginRequest;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@Api(tags = "Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @ApiOperation(value = "Зареєструвати користувача в потребі", notes = "Реєструє нового користувача в потребі")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Користувач успішно зареєстрований"),
            @ApiResponse(code = 400, message = "Неправильний запит")
    })
    @PostMapping("/register/in-need")
    public ResponseEntity<AuthenticationResponse> registerInNeedUser(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.registerInNeedUser(request));
    }

    @ApiOperation(value = "Зареєструвати допоміжника", notes = "Реєструє нового допоміжника")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Допоміжник успішно зареєстрований"),
            @ApiResponse(code = 400, message = "Неправильний запит")
    })
    @PostMapping("/register/helper")
    public ResponseEntity<AuthenticationResponse> registerHelperUser(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.registerHelperUser(request));
    }

    @ApiOperation(value = "Авторизація", notes = "Авторизує користувача")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успішно авторизовано"),
            @ApiResponse(code = 401, message = "Неавторизований доступ"),
            @ApiResponse(code = 403, message = "Заборонено"),
            @ApiResponse(code = 404, message = "Не знайдено")
    })
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}