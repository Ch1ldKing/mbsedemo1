package com.example.mbsedemo1;

import com.example.mbsedemo1.Entity.File;
import com.example.mbsedemo1.Mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class Mbsedemo1Application {

    public static void main(String[] args)
    {
        SpringApplication.run(Mbsedemo1Application.class, args);

    }
    @Bean
    public CommandLineRunner run() {
        return args -> {
            helloWorld(); // 调用你的方法
//            testFullTextSearch();
        };

        
    }

    public void helloWorld() {
        System.out.println("Hello World");
    }

    @Autowired
    private FileMapper fileMapper;

    public void setUp() {
        // 插入测试数据

        File file = new File();
        file.setName("TestFile.txt");
        file.setPath("/test/path");
        file.setSize(1024L);
        file.setUploadTime(new Timestamp(System.currentTimeMillis()));
        file.setContent("This is a sample content for full text search testing.");
        fileMapper.insert(file);
    }

    void testFullTextSearch() {
        // 执行全文搜索
        List<File> results = fileMapper.searchByContent("sample");
        results.stream().forEach(file -> System.out.println(file.getName()));
    }


}
