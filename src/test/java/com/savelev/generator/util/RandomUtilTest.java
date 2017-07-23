package com.savelev.generator.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 14:10.
 */
class RandomUtilTest {
    @Test
    void getRandomObject() {
        assertEquals(0, RandomUtil.getRandomObjectFromArray(new Object[]{0}));
        assertEquals("string", RandomUtil.getRandomObjectFromArray(new Object[]{"string"}));
    }
}