package com.savelev.generator;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 24.07.2017 0:15.
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        new MultipleEventsGenerator().generateEvents(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}
