package com.example.demo.entity;
import java.util.List;

public class MCQIndex {
    private String moduleTitle;
    private List<MCQChapter> MCQchapters;

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public List<MCQChapter> getMCQChapters() {
        return MCQchapters;
    }

    public void setMCQChapters(List<MCQChapter> MCQchapters) {
        this.MCQchapters = MCQchapters;
    }

    public MCQIndex(String moduleTitle, List<MCQChapter> MCQchapters) {
        this.moduleTitle = moduleTitle;
        this.MCQchapters = MCQchapters;
    }

    // Getters and Setters

    public static class MCQChapter {
        private String MCQchapterTitle;
        private List<MCQUnit> MCQunits;

        public String getMCQChapterTitle() {
            return MCQchapterTitle;
        }

        public void setMCQChapterTitle(String MCQchapterTitle) {
            this.MCQchapterTitle = MCQchapterTitle;
        }

        public List<MCQUnit> getMCQUnits() {
            return MCQunits;
        }

        public void setMCQUnits(List<MCQUnit> MCQunits) {
            this.MCQunits = MCQunits;
        }

        public MCQChapter(String MCQchapterTitle, List<MCQUnit> MCQunits) {
            this.MCQchapterTitle = MCQchapterTitle;
            this.MCQunits = MCQunits;
        }

        // Getters and Setters

        public static class MCQUnit {
            private String MCQunitTitle;

            public MCQUnit(String MCQunitTitle) {
                this.MCQunitTitle = MCQunitTitle;
            }

            // Getters and Setters

            public String getMCQUnitTitle() {
                return MCQunitTitle;
            }

            public void setMCQUnitTitle(String MCQunitTitle) {
                this.MCQunitTitle = MCQunitTitle;
            }
        }
    }
}

