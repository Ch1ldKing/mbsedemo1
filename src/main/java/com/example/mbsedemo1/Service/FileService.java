package com.example.mbsedemo1.Service;

import com.example.mbsedemo1.Entity.File;
import com.example.mbsedemo1.Mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    private final FileMapper fileMapper;

    @Autowired
    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public void uploadFile(File file) {
        fileMapper.insert(file);
    }

    public List<File> getAllFiles() {
        return fileMapper.findAll();
    }

    public File getFileById(int id) {
        return fileMapper.findById(id);
    }

    public List<File> getFilesByFolderId(int folderId) {
        return fileMapper.findByFolderId(folderId);
    }

    public List<File> searchFiles(String query) {
        return fileMapper.searchByContent(query);
    }

    public void createFile(File file) {
        fileMapper.insert(file);
    }
    public void save(File file) {
        fileMapper.insert(file);
    }
    // 其他业务方法
}

