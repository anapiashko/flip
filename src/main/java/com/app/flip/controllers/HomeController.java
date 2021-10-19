package com.app.flip.controllers;

import com.app.flip.model.Card;
import com.app.flip.services.CardServiceImpl;
import com.app.flip.services.TextGeneratorServiceImpl;
import com.app.flip.utils.CardTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class HomeController {

    @Autowired
    private CardServiceImpl cardService;

    private final TextGeneratorServiceImpl textGeneratorService;

    public HomeController(TextGeneratorServiceImpl textGeneratorService) {
        this.textGeneratorService = textGeneratorService;
    }

    @GetMapping("/generate")
    public List<Card> generateSampleByTopic(@RequestParam String topic) {
        log.info("Generate Sentences by topic name, topic = {}", topic);
        List<Card> cards = textGeneratorService.getText(topic);
        return cardService.saveAll(cards);
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
