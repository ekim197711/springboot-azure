package com.example.demo.api;

import com.example.demo.blob.MyBlobService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blob")
@RequiredArgsConstructor
public class MyBlobRestController {
    private final MyBlobService myBlobService;

    @GetMapping("/")
    public List<String> blobitemst(){
        return myBlobService.listFiles();
    }
}
