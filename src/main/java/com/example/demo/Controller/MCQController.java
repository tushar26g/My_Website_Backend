package com.example.demo.Controller;

import com.example.demo.entity.MCQ;
import com.example.demo.repo.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/public")
public class MCQController {
    @Autowired
    private MCQRepository mcqRepository;

    @GetMapping("/mcqs")
    public MCQ getMCQByKey(@RequestParam String key) {
        return mcqRepository.findByKey(key);
    }
}

