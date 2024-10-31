package com.example.demo.Controller;

import com.example.demo.entity.IndexBasedRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repo.IndexBasedReadRepo;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your React app
@RequestMapping("/public")
public class IndexBasedWebData {
    @Autowired
    private IndexBasedReadRepo indexBasedRead;

    @GetMapping("/indexBasedWebData")
    public IndexBasedRead getSection(@RequestParam String key) {

        IndexBasedRead result=indexBasedRead.findByKey(key);
        return result;
    }
}
