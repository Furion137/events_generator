package com.savelev.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.savelev.generator.enums.EventType;
import com.savelev.generator.util.RandomUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 24.07.2017 0:07.
 */
public class MultipleEventsGenerator {
    private static final SingleEventGenerator SINGLE_EVENT_GENERATOR = new SingleEventGenerator();//use Spring?
    private static final List<Event> events = Collections.synchronizedList(new ArrayList<>());

    private static final ObjectMapper objectMapper = new ObjectMapper();//datetime format doesn't include timezone
    static {
        objectMapper.getSerializerProvider().setNullValueSerializer(new NullSerializer());
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
//        objectMapper.setDateFormat(df);
    }

    private volatile int unfinishedThreadsAmount;

    private static final int MIN_SLEEP_FOR_JOIN = 3000;
    private static final int MAX_SLEEP_FOR_JOIN = 10000;
    private static final int MIN_SLEEP_FOR_END = 15000;
    private static final int MAX_SLEEP_FOR_END = 60000;


    public void generateEvents(int interactionNumber, int frequency) {
        unfinishedThreadsAmount = interactionNumber;
        
        for (int i = 0; i < interactionNumber; i++) {
            Thread thread = new Thread(new InteractionRunnable());
            thread.start();
            try {
                Thread.sleep(1000/frequency);//we don't take into account time needed to run new thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (unfinishedThreadsAmount > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        writeToFile();
    }

    private static void writeToFile(){
        try {
            objectMapper.writeValue(new File("target/output.json"), events);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class InteractionRunnable implements Runnable {

        @Override
        public void run() {
            Event startEvent = SINGLE_EVENT_GENERATOR.generateEvent(EventType.START, null);
            events.add(startEvent);

            try {
                Thread.sleep(RandomUtil.getRandomInt(MIN_SLEEP_FOR_JOIN, MAX_SLEEP_FOR_JOIN));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Event joinEvent = SINGLE_EVENT_GENERATOR.generateEvent(EventType.JOIN, startEvent);
            events.add(joinEvent);

            try {
                Thread.sleep(RandomUtil.getRandomInt(MIN_SLEEP_FOR_END, MAX_SLEEP_FOR_END));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Event endEvent = SINGLE_EVENT_GENERATOR.generateEvent(EventType.END, joinEvent);
            events.add(endEvent);
            synchronized (MultipleEventsGenerator.class){
                unfinishedThreadsAmount--;
            }
        }
    }
}
