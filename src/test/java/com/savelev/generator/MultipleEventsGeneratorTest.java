package com.savelev.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 24.07.2017 0:08.
 */
class MultipleEventsGeneratorTest {
    @Test
    void generateEvents() {
        MultipleEventsGenerator multipleEventsGenerator = new MultipleEventsGenerator();
        multipleEventsGenerator.generateEvents(3, 5);
    }
}