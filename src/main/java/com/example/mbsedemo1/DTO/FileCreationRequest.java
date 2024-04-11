package com.example.mbsedemo1.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FileCreationRequest {

    @NotNull(message = "Folder ID cannot be null")
    private Integer folderId;

    private String content;

    @NotBlank(message = "File name cannot be blank")
    private String name;

    // Getters and Setters
    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
