package com.example.mbsedemo1.Entity;

import lombok.Data;

@Data
public class ProjectCreationRequest {
    private String fileName;
    // 可以添加更多字段，例如项目描述等

    // getter和setter
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
