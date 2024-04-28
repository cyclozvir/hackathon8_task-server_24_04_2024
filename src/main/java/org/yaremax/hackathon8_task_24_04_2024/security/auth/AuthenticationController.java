package org.yaremax.hackathon8_task_24_04_2024.security.auth;

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
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register/in-need")
    public ResponseEntity<AuthenticationResponse> registerInNeedUser(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.registerInNeedUser(request));
    }
    @PostMapping("/register/helper")
    public ResponseEntity<AuthenticationResponse> registerHelperUser(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.registerHelperUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
