package com.example.demo.api;

import com.example.demo.blob.MyBlobService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file) throws IOException {
        log.info("Filename :" + file.getOriginalFilename());
        log.info("Size:" + file.getSize());
        log.info("Contenttype:" + file.getContentType());
        myBlobService.storeFile(file.getOriginalFilename(),file.getInputStream(), file.getSize());
        return file.getOriginalFilename() + " Has been saved as a blob-item!!!";

    }
}
