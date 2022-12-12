package com.app.flip.model;

public enum CardTopic {
    VOCABULARY (0),
    IDIOMS (1),

    PHRASAL_VERB (2),

    COLLOCATIONS (3);

    private final Integer ordinal;

    CardTopic(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Integer getOrdinal() {
        return ordinal;
    }
}
