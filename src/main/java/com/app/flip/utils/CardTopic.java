package com.app.flip.utils;

public enum CardTopic {
    HEALTH ("health"),
    TRAVEL ("travel");

    private final String typeName;

    CardTopic(String typeName) {
        this.typeName = typeName;
    }

    public static CardTopic fromString(String text) {
        for (CardTopic b : CardTopic.values()) {
            if (b.typeName.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
