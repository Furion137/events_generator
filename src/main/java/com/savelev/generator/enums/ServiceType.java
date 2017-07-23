package com.savelev.generator.enums;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 10:50.
 */
public enum ServiceType {
    NEW_ACCOUNT("new account"),
    PAYMENT("payment"),
    DELIVERY("delivery");

    private final String type;

    private ServiceType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
