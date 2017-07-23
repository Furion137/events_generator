package com.savelev.generator.util;

import java.util.Random;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 11:19.
 */
public class RandomUtil {
    private static Random random = new Random();

    public static Object getRandomObjectFromArray(Object[] objects){
        int randomIndex = random.nextInt(objects.length);
        return objects[randomIndex];
    }

    public static String generateAgentId(){
        int number = random.nextInt(1000) - 1;
        return "Agent_" + number;
    }

    public static int getRandomInt(int from, int to){
        return random.nextInt(to - from + 1) + from - 1;
    }
}
