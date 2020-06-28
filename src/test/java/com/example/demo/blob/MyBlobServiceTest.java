package com.example.demo.blob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MyBlobServiceTest {

    @Autowired
    MyBlobService blobService;

    @Test
    public void tryListFiles(){
        List<String> strings = blobService.listFiles();
        Assertions.assertNotNull(strings);
        strings.forEach(System.out::println);
    }

}