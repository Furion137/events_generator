package com.savelev.generator.enums;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 14:28.
 */
public enum EndReason {
    NORMAL("Normal"),
    ABNORMAL("Abnormal");

    private final String type;

    private EndReason(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
