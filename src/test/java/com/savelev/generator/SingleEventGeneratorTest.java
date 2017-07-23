package com.savelev.generator;

import com.savelev.generator.enums.EventType;
import org.junit.jupiter.api.Test;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 14:21.
 */
class SingleEventGeneratorTest {

    @Test
    void generateEvent() {
        SingleEventGenerator singleEventGenerator = new SingleEventGenerator();
        singleEventGenerator.generateEvent(EventType.START, null);
    }
}