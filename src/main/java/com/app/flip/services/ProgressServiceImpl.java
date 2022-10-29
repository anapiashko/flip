package com.app.flip.services;

import com.app.flip.dao.ProgressRepository;
import com.app.flip.model.Progress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Slf4j
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
        Integer userId = Integer.parseInt(json.get("userId"));
        Progress progress = progressRepository.findByCardIdAndUserId(cardId, userId);
        if (progress == null) {
            progress = progressRepository.save(new Progress(cardId, userId));
        } else {
            if (typedCorrect) {
                progress.setProbability(progress.getProbability().multiply(new BigDecimal("0.9")));
            } else {
                progress.setProbability(progress.getProbability().divide(new BigDecimal("0.9"), RoundingMode.HALF_UP));
            }
            progress = progressRepository.save(progress);
        }

        log.info("Progress : " + progress);
    }
}
