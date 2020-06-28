package com.example.demo.blob;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MyBlobService {

    @Value("${azure.myblob.url}")
    private String azureurl;

    @Value("${azure.myblob.container}")
    private String containerName;

    private BlobContainerClient containerClient() {
        log.info("url: {}", azureurl);
        log.info("container: {}", containerName);
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .connectionString(azureurl).buildClient();
        BlobContainerClient container = serviceClient.getBlobContainerClient(containerName);
        return container;
    }

    public List<String> listFiles() {
        log.info("List blobs BEGIN");
        BlobContainerClient container = containerClient();
        val list = new ArrayList<String>();
        for (BlobItem blobItem : container.listBlobs()) {
            log.info("Blob {}", blobItem.getName());
            list.add(blobItem.getName());
        }
        log.info("List blobs END");
        return list;
    }

}

