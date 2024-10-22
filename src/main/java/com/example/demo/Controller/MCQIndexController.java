package com.example.demo.Controller;

import com.example.demo.entity.MCQIndex;
import com.example.demo.entity.MCQIndex.MCQChapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/public")
public class MCQIndexController {
    @GetMapping("/mcqindex")
    public ResponseEntity<List<MCQIndex>> getIndex(@RequestParam String key) {
        List<MCQIndex> index = List.of(
                new MCQIndex("Module 1", List.of(
                        new MCQIndex.MCQChapter("Theoretical Framework", List.of(
                                new MCQChapter.MCQUnit("MEANING AND SCOPE OF ACCOUNTING"),
                                new MCQChapter.MCQUnit("MCQUnit 2"),
                                new MCQChapter.MCQUnit("MCQUnit 3")
                        )),
                        new MCQChapter("chap2", List.of(
                                new MCQChapter.MCQUnit("MCQUnit 1")
                        )),
                        new MCQChapter("chap3",  List.of(
                                new MCQChapter.MCQUnit( "MCQUnit 1")
                        ))
                )),
                new MCQIndex("mod2", List.of(
                        new MCQChapter("chap8", List.of(
                                new MCQChapter.MCQUnit("MCQunit1")
                        )),
                        new MCQChapter("chap9", List.of(
                                new MCQChapter.MCQUnit("MCQunit1")
                        )),
                        new MCQChapter("chap10", List.of(
                                new MCQChapter.MCQUnit("MCQunit1")
                        )),
                        new MCQChapter("chap11", List.of(
                                new MCQChapter.MCQUnit("MCQunit1")
                        ))
                ))
        );

        return ResponseEntity.ok(index);
    }
}
