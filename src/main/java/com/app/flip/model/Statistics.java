package com.app.flip.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Statistics {
    private Double vocabularyPercentage;
    private Double idiomsPercentage;
    private Double phrasalVerbsPercentage;
    private Double collocationsPercentage;
}
