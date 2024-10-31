package com.example.demo.Controller;

import com.example.demo.Configuration.JwtUtil;
import com.example.demo.entity.AuthenticationResponse;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;  // Inject your JwtUtil
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String token) {
        String refreshToken = token.substring(7); // Remove "Bearer " prefix

        // Extract the email from the token (we'll fix the private access issue)
        String userEmail = jwtUtil.extractEmail(refreshToken);  // Use email extraction instead of username

        // Fetch the user by email
        User user = userRepository.findByEmail(userEmail);  // Ensure you have this method in your UserService

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }

        if (jwtUtil.validateToken(refreshToken, user)) {
            String newAccessToken = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(new AuthenticationResponse(newAccessToken));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired refresh token");
    }
}