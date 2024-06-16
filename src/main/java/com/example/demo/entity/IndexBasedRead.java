package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "Accounting")
public class IndexBasedRead {
    @Id
    private String id;
    private String heading;
    private String key;
    private String previous;
    private String next;
    private BodyIndex bodyIndex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public BodyIndex getBodyIndex() {
        return bodyIndex;
    }

    public void setBodyIndex(BodyIndex bodyIndex) {
        this.bodyIndex = bodyIndex;
    }
// Getters and setters
}

class BodyIndex {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Map<String, Object>> getContent() {
        return content;
    }

    public void setContent(List<Map<String, Object>> content) {
        this.content = content;
    }

    private List<Map<String, Object>> content;


}
