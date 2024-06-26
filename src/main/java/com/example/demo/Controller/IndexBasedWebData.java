package com.example.demo.Controller;

import com.example.demo.entity.IndexBasedRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repo.IndexBasedReadRepo;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your React app
@RequestMapping("/indexBasedWebData")
public class IndexBasedWebData {
    @Autowired
    private IndexBasedReadRepo indexBasedRead;

    @GetMapping
    public IndexBasedRead getSection(@RequestParam String key) {
        return indexBasedRead.findByKey(key);
    }
}
