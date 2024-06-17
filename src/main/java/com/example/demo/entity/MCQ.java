package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Data
@Document(collection = "MCQ")
public class MCQ {
    @Id
    private String id;
    private String key;
    private List<Question> questions;
}


@Data
class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;
    private String reason;  // Corrected from "reson" to "reason"
}