package com.savelev.generator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.savelev.generator.enums.EventType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 15:09.
 */
public class InteractionRunnable implements Runnable {
    private static final EventGenerator eventGenerator = new EventGenerator();//use Spring?
    private static final List<Event> events = Collections.synchronizedList(new ArrayList<>());

    private static final ObjectMapper objectMapper = new ObjectMapper();//datetime format doesn't include timezone
    static {
        objectMapper.getSerializerProvider().setNullValueSerializer(new NullSerializer());
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
//        objectMapper.setDateFormat(df);
    }

    @Override
    public void run() {
        Event startEvent = eventGenerator.generateEvent(EventType.START, null);
        events.add(startEvent);

        try {
            Thread.sleep(RandomUtil.getRandomInt(3000, 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Event joinEvent = eventGenerator.generateEvent(EventType.JOIN, startEvent);
        events.add(joinEvent);

        try {
            Thread.sleep(RandomUtil.getRandomInt(5000, 10000));//todo 15-60
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Event endEvent = eventGenerator.generateEvent(EventType.END, joinEvent);
        events.add(endEvent);
    }

    public static void writeToFile(){
        try {
            objectMapper.writeValue(new File("output.json"), events);
            System.out.println(objectMapper.writeValueAsString(events));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
