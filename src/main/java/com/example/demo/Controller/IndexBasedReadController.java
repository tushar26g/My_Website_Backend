package com.example.demo.Controller;

import com.example.demo.entity.IndexForIndexRead;
import com.example.demo.entity.IndexItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
public class IndexBasedReadController {

    @GetMapping("/indexBasedRead")
    public ResponseEntity<List<IndexForIndexRead>> getIndex(@RequestParam String key) {
        List<IndexForIndexRead> allData = Arrays.asList(
                new IndexForIndexRead("Module 1", Arrays.asList(
                        new IndexForIndexRead.Chapter("Theoretical Framework", Arrays.asList(
                                new IndexForIndexRead.Chapter.Unit("MEANING AND SCOPE OF ACCOUNTING", Arrays.asList(
                                        new IndexItem("Accounting1001", "INTRODUCTION"),
                                        new IndexItem("Accounting1002", "Meaning_of_Accounting"),
                                        new IndexItem("Accounting1003", "EVOLUTION OF ACCOUNTING AS A SOCIAL SCIENCE"),
                                        new IndexItem("Accounting1004", "OBJECTIVES OF ACCOUNTING"),
                                        new IndexItem("Accounting1005", "FUNCTIONS OF ACCOUNTING"),
                                        new IndexItem("Accounting1006", "BOOK-KEEPING")
                                )),
                                new IndexForIndexRead.Chapter.Unit("Unit 2", Arrays.asList(
                                        new IndexItem("Accounting2001", "Topic 1"),
                                        new IndexItem("Accounting2002", "Topic 2")
                                )),
                                new IndexForIndexRead.Chapter.Unit("Unit 3", Arrays.asList(
                                        new IndexItem("Accounting3001", "Topic 1")
                                ))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 2", Arrays.asList(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", Arrays.asList(
                                        new IndexItem("Accounting4001", "Topic 1"),
                                        new IndexItem("Accounting4002", "Topic 2"),
                                        new IndexItem("Accounting4003", "Topic 3")
                                ))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 3", Arrays.asList(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", Arrays.asList(
                                        new IndexItem("Accounting5001", "Topic 1"),
                                        new IndexItem("Accounting5002", "Topic 2")
                                ))
                        ))
                )),
                new IndexForIndexRead("Module 2", Arrays.asList(
                        new IndexForIndexRead.Chapter("Chapter 8", Arrays.asList(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", Arrays.asList(
                                        new IndexItem("Accounting6001", "Topic 1"),
                                        new IndexItem("Accounting6002", "Topic 2")
                                ))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 9", Arrays.asList(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", Arrays.asList(
                                        new IndexItem("Accounting7001", "Topic 1"),
                                        new IndexItem("Accounting7002", "Topic 2"),
                                        new IndexItem("Accounting7003", "Topic 3")
                                ))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 10", Arrays.asList(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", Arrays.asList(
                                        new IndexItem("Accounting8001", "Topic 1")
                                ))
                        )),
                        new IndexForIndexRead.Chapter("Chapter 11", Arrays.asList(
                                new IndexForIndexRead.Chapter.Unit("Unit 1", Arrays.asList(
                                        new IndexItem("Accounting9001", "Topic 1"),
                                        new IndexItem("Accounting9002", "Topic 2")
                                ))
                        ))
                ))
        );

        List<IndexForIndexRead> filteredData = allData.stream()
                .filter(module -> module.getModuleTitle().equalsIgnoreCase(key))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredData.isEmpty() ? allData : filteredData);
    }
}
