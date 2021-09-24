package com.app.flip.controllers;

import com.app.flip.dao.CardRepository;
import com.app.flip.model.Card;
import com.app.flip.services.TextGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class HomeController {

    @Autowired
    private CardRepository repository;

    private final TextGeneratorServiceImpl textGeneratorService;

    public HomeController(TextGeneratorServiceImpl textGeneratorService) {
        this.textGeneratorService = textGeneratorService;
    }

    @GetMapping("/a")
    public List<Card> homeA() {
        return textGeneratorService.getText();
    }

    @GetMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @GetMapping("/get")
    public Card home1() {
        Card va = repository.findById(1).get();
        return va;
    }

//    @RequestMapping("/tmp")
//    public ResponseEntity<InputStreamResource> getTmp() throws IOException {
//
//        Path path = Paths.get("src","main", "resources", "records", "silly.mp3");
//        String contentType = Files.probeContentType(path);
//        FileSystemResource file = new FileSystemResource(path);
//        Card card = repository.findById(1).get();
//        return ResponseEntity
//                .ok()
//                .contentLength(file.contentLength())
//                .contentType(MediaType.parseMediaType(contentType))
//                .body(new InputStreamResource(new ByteArrayInputStream(card.getRecord().getData())));
//    }
}
