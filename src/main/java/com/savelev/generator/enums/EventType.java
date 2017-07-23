package com.savelev.generator.enums;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 10:42.
 */
public enum EventType {
    START("start"),
    JOIN("join"),
    END("end");

    private final String type;

    private EventType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
