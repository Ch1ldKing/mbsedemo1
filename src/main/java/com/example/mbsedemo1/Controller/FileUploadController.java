//package com.example.mbsedemo1.Controller;
//
//import com.example.mbsedemo1.Entity.File;
//import com.example.mbsedemo1.Service.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.Timestamp;
//
//@RestController
//public class FileUploadController {
//
//    private static final String UPLOAD_DIR = "./uploads/";
//
//    @Autowired
//    private FileService fileService; // 假设你有一个FileService来处理数据库操作
//
//    @PostMapping("/upload")
//    public String uploadFile(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return "The file is empty";
//        }
//
//        // 限制文件类型为txt
//        if (!file.getContentType().equals("text/plain")) {
//            return "Only txt files are allowed";
//        }
//
//        try {
//
//            Path uploadPath = Paths.get(UPLOAD_DIR);
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            // 读取文件内容
//            String content = new String(bytes);
//
//            // 创建File对象并保存到数据库
//            File fileToSave = new File();
//            fileToSave.setName(file.getOriginalFilename());
//            fileToSave.setSize(file.getSize());
//            fileToSave.setUploadTime(new Timestamp(System.currentTimeMillis()));
//            fileToSave.setContent(content);
//
//            fileService.save(fileToSave); // 调用Service层方法保存File对象
//
//            return "File uploaded successfully: " + file.getOriginalFilename();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "File upload failed: " + e.getMessage();
//        }
//    }
//}
