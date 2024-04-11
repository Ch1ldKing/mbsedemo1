package com.example.mbsedemo1.Entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class File {
    private Integer id;
    private String name;
    private String path;
    private Long size;
    private Timestamp uploadTime;
    private String content;
    private Integer folderId; // 外键，指向 Folder

    // 构造函数
    public File() {}

    // Getters 和 Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // toString 方法，可选，用于打印对象信息
    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", uploadTime=" + uploadTime +
                ", content='" + content + '\'' +
                '}';
    }
}
