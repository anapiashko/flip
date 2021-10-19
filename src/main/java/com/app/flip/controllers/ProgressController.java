package com.app.flip.controllers;

import com.app.flip.services.ProgressServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class ProgressController {

    private final ProgressServiceImpl progressService;

    public ProgressController(ProgressServiceImpl progressService) {
        this.progressService = progressService;
    }

    @PostMapping("/change-progress")
    public void changeProgressOnDemand(@RequestBody Map<String, String> json) {
        log.info("Input json is: {}", json);
        progressService.updateProgress(json);
    }

}
