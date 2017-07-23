package com.savelev.generator.enums;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 14:31.
 */
public enum OriginationPage {
    WEBCHAT("login"),
    SMS("balance"),
    WECHAT("transfer");

    private final String type;

    private OriginationPage(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
