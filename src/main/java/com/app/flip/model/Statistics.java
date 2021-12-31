package com.app.flip.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Statistics {
    private Double healthPercentage;
    private Double travelPercentage;
}
