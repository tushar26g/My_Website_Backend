package com.example.demo.Controller;

import com.example.demo.entity.MCQ;
import com.example.demo.repo.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mcqs")
public class MCQController {
    @Autowired
    private MCQRepository mcqRepository;

    @GetMapping("/{key}")
    public MCQ getMCQByKey(@PathVariable String key) {
        return mcqRepository.findByKey(key);
    }
}

