package com.app.flip.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer cardId;

    private BigDecimal probability = new BigDecimal("1.00");

    private Integer userId;

    public Progress (Integer cardId) {
        this.cardId = cardId;
    }

    public Progress (Integer cardId, Integer userId) {
        this.cardId = cardId;
        this.userId = userId;
    }
}
