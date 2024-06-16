package com.example.demo.repo;
import com.example.demo.entity.IndexBasedRead;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IndexBasedReadRepo extends MongoRepository<IndexBasedRead, String> {
    IndexBasedRead findByKey(String key);
}
