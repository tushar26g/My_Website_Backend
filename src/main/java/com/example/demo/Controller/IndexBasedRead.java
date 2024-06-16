package com.example.demo.Controller;
import com.example.demo.entity.IndexForIndexRead;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
public class IndexBasedRead {
    @GetMapping("/indexBasedRead")
    public ResponseEntity<List<IndexForIndexRead>> getIndex(@RequestParam String key) {
        List<IndexForIndexRead> index = List.of(
                new IndexForIndexRead("Module 1", List.of(
                        new IndexForIndexRead.Chapter("Theoretical Framework", List.of(
                                new IndexForIndexRead.Chapter.Unit("MEANING AND SCOPE OF ACCOUNTINGMEANING AND SCOPE OF ACCOUNTING", List.of("INTRODUCTION", "Meaning_of_Accounting", "EVOLUTION OF ACCOUNTING AS A SOCIAL SCIENCE","OBJECTIVES OF ACCOUNTING","FUNCTIONS OF ACCOUNTING","BOOK-KEEPING")),
                                new IndexForIndexRead.Chapter.Unit("Unit 2", List.of("Topic 1", "Topic 2")),
                                new IndexForIndexRead.Chapter.Unit("Unit 3", List.of("Topic 1"))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 2", List.of(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", List.of("Topic 1", "Topic 2", "Topic 3"))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 3", List.of(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", List.of("Topic 1", "Topic 2"))
                        ))
                )),
                new IndexForIndexRead("Module 2", List.of(
                        new IndexForIndexRead.Chapter("Chapter 8", List.of(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", List.of("Topic 1", "Topic 2"))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 9", List.of(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", List.of("Topic 1", "Topic 2", "Topic 3"))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 10", List.of(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", List.of("Topic 1"))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 11", List.of(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", List.of("Topic 1", "Topic 2"))
                        ))
                ))
        );

        return ResponseEntity.ok(index);
    }
}
