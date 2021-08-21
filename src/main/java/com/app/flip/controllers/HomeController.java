package com.app.flip.controllers;

import com.app.flip.dao.CardRepository;
import com.app.flip.model.Card;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class HomeController {

    private final CardRepository repository;

    public HomeController(CardRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @RequestMapping("/tmp")
    public ResponseEntity<InputStreamResource> getTmp() throws IOException {

        Path path = Paths.get("src","main", "resources", "records", "silly.mp3");
        String contentType = Files.probeContentType(path);
        FileSystemResource file = new FileSystemResource(path);
        Card card = repository.findById(1).get();
        return ResponseEntity
                .ok()
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType(contentType))
                .body(new InputStreamResource(new ByteArrayInputStream(card.getRecord().getData())));
    }
}
