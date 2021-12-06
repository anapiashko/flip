package com.app.flip.utils;

public enum CardTopic {
    HEALTH (0),
    TRAVEL (1);

    private final Integer ordinal;

    CardTopic(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Integer getOrdinal() {
        return ordinal;
    }
}
