package com.example.mbsedemo1.Entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Folder {
    private Integer id;
    private String name;
    private Integer projectId; // 外键，指向 Project
    private Timestamp createdAt;
    // 文件夹与文件的一对多关系
    private List<File> files;

    // getters and setters
}
