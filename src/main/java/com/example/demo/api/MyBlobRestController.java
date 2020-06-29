package com.example.demo.api;

import com.example.demo.blob.MyBlobService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blob")
@RequiredArgsConstructor
@Slf4j
public class MyBlobRestController {
    private final MyBlobService myBlobService;

    @GetMapping("/")
    public List<String> blobitemst() {
        return myBlobService.listFiles();
    }


    @GetMapping("/download/{filename}")
    public byte[] download(@PathVariable String filename) {
        log.info("download blobitem: {}", filename);
         return myBlobService.downloadFile(filename).toByteArray();
    }

}
