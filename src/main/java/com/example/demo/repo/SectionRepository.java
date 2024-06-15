package com.example.demo.repo;

import com.example.demo.entity.Section;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SectionRepository extends MongoRepository<Section, String> {
    Section findByKey(String key);
}

