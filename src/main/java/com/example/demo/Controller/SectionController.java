package com.example.demo.Controller;

import com.example.demo.entity.Section;
import com.example.demo.entity.IndexBasedRead;
import com.example.demo.repo.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your React app
@RequestMapping("/public")
public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;

    @GetMapping("/section")
    public Section getSection(@RequestParam String key) {
//        System.out.println("Tushar");
        return sectionRepository.findByKey(key);
    }
}
