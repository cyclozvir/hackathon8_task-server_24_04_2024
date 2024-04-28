package org.yaremax.hackathon8_task_24_04_2024.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yaremax.hackathon8_task_24_04_2024.security.auth.records.LoginRequest;
import org.yaremax.hackathon8_task_24_04_2024.security.auth.records.RegisterRequest;
import org.yaremax.hackathon8_task_24_04_2024.security.auth.records.AuthenticationResponse;
import org.yaremax.hackathon8_task_24_04_2024.security.jwt.JwtService;
import org.yaremax.hackathon8_task_24_04_2024.models.user.Role;
import org.yaremax.hackathon8_task_24_04_2024.models.user.UserDetailsImpl;
import org.yaremax.hackathon8_task_24_04_2024.models.user.UserEntity;
import org.yaremax.hackathon8_task_24_04_2024.models.user.UserService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse registerInNeedUser(RegisterRequest request) {
        UserEntity userEntity = UserEntity.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.IN_NEED)
                .build();
        userService.addUser(userEntity);

        String jwtToken = jwtService.generateToken(new UserDetailsImpl(userEntity));
        return new AuthenticationResponse(jwtToken, userEntity.getRole());
    }

    public AuthenticationResponse registerHelperUser(RegisterRequest request) {
        UserEntity userEntity = UserEntity.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.HELPER)
                .build();
        userService.addUser(userEntity);

        String jwtToken = jwtService.generateToken(new UserDetailsImpl(userEntity));
        return new AuthenticationResponse(jwtToken, userEntity.getRole());
    }

    public AuthenticationResponse login(LoginRequest request) {
        // will also check if username and password are correct
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password())
        );

        UserEntity userEntity = userService.findUserByEmail(request.email());

        String jwtToken = jwtService.generateToken(new UserDetailsImpl(userEntity));
        return new AuthenticationResponse(jwtToken, userEntity.getRole());
    }
}
