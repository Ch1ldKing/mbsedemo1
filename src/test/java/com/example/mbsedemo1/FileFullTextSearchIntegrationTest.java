package com.example.mbsedemo1;

import com.example.mbsedemo1.Entity.File;
import com.example.mbsedemo1.Mapper.FileMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class FileFullTextSearchIntegrationTest {

    @Autowired
    private FileMapper fileMapper;

    @BeforeEach
    void setUp() {
        // 插入测试数据
        File file = new File();
        file.setName("TestFile.txt");
        file.setPath("/test/path");
        file.setSize(1024L);
        file.setUploadTime(new Timestamp(System.currentTimeMillis()));
        file.setContent("This is a sample content for full text search testing.");
        fileMapper.insert(file);
    }

    @AfterEach
    void tearDown() {
        // 清理测试数据
        fileMapper.deleteAll();
    }

    @Test
    void testFullTextSearch() {
        // 执行全文搜索
        List<File> results = fileMapper.searchByContent("sample");

        // 验证结果
        assertFalse(results.isEmpty(), "Expected at least one result for 'sample'");

        boolean matchFound = results.stream()
                .anyMatch(file -> file.getContent().contains("sample"));
        assertTrue(matchFound, "Expected the content to contain 'sample'");
    }
}
