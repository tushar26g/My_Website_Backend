package com.example.demo.Controller;

import com.example.demo.Configuration.JwtUtil;
import com.example.demo.entity.AuthenticationRequest;
import com.example.demo.entity.AuthenticationResponse;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/public")
public class Sign {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Properly autowire the PasswordEncoder


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AuthenticationRequest request) {
        if (userRepository.findByEmail(request.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthenticationResponse("Username already exists"));
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setMobileNo(request.getMobileNo());
        user.setCoins(50);  // Grant 50 coins for registration

        userRepository.save(user);

        return ResponseEntity.ok(new AuthenticationResponse("User registered successfully with 50 coins"));
    }


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthenticationResponse("User not found"));
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthenticationResponse("Incorrect username or password"));
        }

        Date today = new Date();
        if (user.getLastLoginDate() == null || isNewDay(user.getLastLoginDate(), today)) {
            user.setCoins(user.getCoins() + 2);  // Add 2 coins for login if a new day
            user.setLastLoginDate(today);
            userRepository.save(user);  // Update user with new coin balance and last login date
        }

        String jwt = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    // Helper method to check if it's a new day since the last login
    private boolean isNewDay(Date lastLoginDate, Date currentDate) {
        // Check if the current date and last login date are not the same day
        return lastLoginDate == null || (currentDate.getDay() != lastLoginDate.getDay() || currentDate.getMonth() != lastLoginDate.getMonth());
    }
}
