package com.example.demo.repo;


import com.example.demo.entity.MCQ;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MCQRepository extends MongoRepository<MCQ, String> {
    MCQ findByKey(String key);
}