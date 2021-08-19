package com.app.flip.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class HomeController {

    @GetMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @RequestMapping(value = "/getsong")
    public ResponseEntity<byte[]> getsong(HttpServletResponse response) {
        try {
            Path path = Paths.get("src","main", "resources", "records", "silly.mp3");
            response.setContentType("audio/mp3");
            response.setContentLength((int) Files.size(path));
            Files.copy(path, response.getOutputStream());
            response.flushBuffer();

        } catch (Exception ignored) {
        }
        return null;
    }
}
