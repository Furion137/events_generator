package com.savelev.generator;

import com.savelev.generator.EventGenerator;
import com.savelev.generator.enums.EventType;
import org.junit.jupiter.api.Test;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 14:21.
 */
class EventGeneratorTest {
    @Test
    void generateEvents() {
        EventGenerator eventGenerator = new EventGenerator();
        eventGenerator.generateEvents(3, 5);
    }

    @Test
    void generateEvent() {
        EventGenerator eventGenerator = new EventGenerator();
        eventGenerator.generateEvent(EventType.START, null);
    }

}