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
        // Check if username already exists
        if (userRepository.findByEmail(request.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthenticationResponse("Username already exists"));
        }

        // Create a new user
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Encode the password
        user.setMobileNo(request.getMobileNo());

        userRepository.save(user); // Save the user to MongoDB

        return ResponseEntity.ok(new AuthenticationResponse("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) {
        System.out.println("Enter");
        User user = userRepository.findByEmail(request.getEmail());
        System.out.println(user);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthenticationResponse("User not found"));
        }
        System.out.println("user found");
        // Check if the password matches
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthenticationResponse("Incorrect username or password"));
        }
        System.out.println(request.getPassword()+" "+ user.getPassword());
        // If authentication is successful, generate JWT token
        final String jwt = jwtUtil.generateToken(user.getEmail());
        System.out.println("End");
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
