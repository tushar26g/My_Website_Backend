package com.example.demo.Controller;
import com.example.demo.entity.IndexItem;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/public")
public class IndexController {

    @GetMapping("/index")
    public List<IndexItem> getIndex(@RequestParam String key) {
        // Example data for index items
        if(key.equals("excel1002")) {
            List<IndexItem> indexItems = Arrays.asList(
                    new IndexItem("excel1001", "Excel Basics"),
                    new IndexItem("excel1002", "File Operations"),
                    new IndexItem("excel1003", "Data Manipulation"),
                    new IndexItem("excel1004", "Advanced Formulas"),
                    new IndexItem("excel1005", "Pivot Tables")
                    // Add more items as needed
            );
            return indexItems;
        }
            return null;

//        return indexItems;
    }
}
