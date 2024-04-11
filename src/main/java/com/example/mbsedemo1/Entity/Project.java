package com.example.mbsedemo1.Entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Project {
    private Integer id;
    private Integer folderId;
    private String name;
    private Timestamp uploadTime;
    // 其他属性
    // 项目与文件夹的一对多关系
    private List<Folder> folders;

    // getters and setters
}
