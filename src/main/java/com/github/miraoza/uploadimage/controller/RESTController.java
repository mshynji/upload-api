package com.github.miraoza.uploadimage.controller;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import com.github.miraoza.uploadimage.storage.ImageUploader;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
    static final String saveDirectory  = "/var/www/api-images";

    @PostMapping("/upload-image/{id}")
    public static String uploadImage(@PathVariable("id") long id, @RequestParam("file") MultipartFile file) throws Exception {
        String uploadDir = saveDirectory + "/" + id + "/";
        Path path = ImageUploader.salvarImagem(uploadDir, file);

        return path.toString();
    }
}