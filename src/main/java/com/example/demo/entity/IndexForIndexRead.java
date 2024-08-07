package com.example.demo.entity;

import java.util.List;

public class IndexForIndexRead {
    private String moduleTitle;
    private List<Chapter> chapters;

    public IndexForIndexRead(String moduleTitle, List<Chapter> chapters) {
        this.moduleTitle = moduleTitle;
        this.chapters = chapters;
    }

    // Getters and Setters
    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public static class Chapter {
        private String chapterTitle;
        private List<Unit> units;

        public Chapter(String chapterTitle, List<Unit> units) {
            this.chapterTitle = chapterTitle;
            this.units = units;
        }

        // Getters and Setters
        public String getChapterTitle() {
            return chapterTitle;
        }

        public void setChapterTitle(String chapterTitle) {
            this.chapterTitle = chapterTitle;
        }

        public List<Unit> getUnits() {
            return units;
        }

        public void setUnits(List<Unit> units) {
            this.units = units;
        }

        public static class Unit {
            private String unitTitle;
            private List<IndexItem> topics;

            public Unit(String unitTitle, List<IndexItem> topics) {
                this.unitTitle = unitTitle;
                this.topics = topics;
            }

            // Getters and Setters
            public String getUnitTitle() {
                return unitTitle;
            }

            public void setUnitTitle(String unitTitle) {
                this.unitTitle = unitTitle;
            }

            public List<IndexItem> getTopics() {
                return topics;
            }

            public void setTopics(List<IndexItem> topics) {
                this.topics = topics;
            }
        }
    }
}
