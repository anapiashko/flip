package com.app.flip.services;

import com.app.flip.dao.ProgressRepository;
import com.app.flip.model.Progress;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ProgressServiceImpl {

    private final ProgressRepository progressRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public void saveAll(List<Progress> progresses){
        progressRepository.saveAll(progresses);
    }

    /**
     * Update probability field in progress table.
     *
     * @param json contains Integer card_id and boolean typed_correct
     */
    public void updateProgress(Map<String, String> json) {
        Integer cardId = Integer.parseInt(json.get("card_id"));
        boolean typedCorrect = Boolean.parseBoolean(json.get("typed_correct"));
        Progress progress = progressRepository.findByCardId(cardId);
        if (progress == null) {
            progress = progressRepository.save(new Progress(cardId));
        } else {
            if (typedCorrect) {
                progress.setProbability(progress.getProbability().multiply(new BigDecimal("0.9")));
            } else {
                progress.setProbability(progress.getProbability().divide(new BigDecimal("0.9")));
            }
            progress = progressRepository.save(progress);
        }

        System.out.println("Progress : " + progress);
    }
}
