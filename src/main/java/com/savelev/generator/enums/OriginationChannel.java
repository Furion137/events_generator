package com.savelev.generator.enums;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 14:24.
 */
public enum OriginationChannel {
    WEBCHAT("webchat"),
    SMS("sms"),
    WECHAT("wechat");

    private final String type;

    private OriginationChannel(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
