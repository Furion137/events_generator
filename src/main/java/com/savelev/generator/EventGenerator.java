package com.savelev.generator;

import com.savelev.generator.enums.EndReason;
import com.savelev.generator.enums.EventType;
import com.savelev.generator.enums.OriginationChannel;
import com.savelev.generator.enums.OriginationPage;
import com.savelev.generator.enums.ServiceType;

import java.util.Date;
import java.util.UUID;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 10:40.
 */
public class EventGenerator {
    private static final Date UNDEFINED_TIME_STAMP = new Date(0);

    public void generateEvents(int interactionNumber, int frequency) {
        for (int i = 0; i < interactionNumber; i++) {
            Thread thread = new Thread(new InteractionRunnable());
            thread.start();
            try {
                Thread.sleep(1000/frequency);//we don't take into account time needed to run new thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        InteractionRunnable.writeToFile();
    }

    public Event generateEvent(EventType eventType, Event event) {
        switch (eventType) {
            case START:
                return generateStartEvent();
            case JOIN:
                return generateJoinEvent(event);
            case END:
                return generateEndEvent(event);
        }
        throw new RuntimeException("Unexpected exception");
    }

    private Event generateStartEvent() {
        Event result = new Event();

        result.setId(UUID.randomUUID());
        result.setEventType(EventType.START);
        result.setEventTimeStamp(new Date());

        result.setCreateTime(new Date());
        result.setDeliveryTime(UNDEFINED_TIME_STAMP);
        result.setEndTime(UNDEFINED_TIME_STAMP);

        result.setServiceType((ServiceType) RandomUtil.getRandomObjectFromArray(ServiceType.values()));
        result.setOriginationPage((OriginationPage) RandomUtil.getRandomObjectFromArray(OriginationPage.values()));
        result.setOriginationChannel((OriginationChannel) RandomUtil.getRandomObjectFromArray(OriginationChannel.values()));

        result.setEndReason(null);

        return result;
    }

    private Event generateJoinEvent(Event event) {
        if (!event.getEventType().equals(EventType.START)) {
            throw new IllegalArgumentException("Wrong event type");
        }

        Event result = new Event();

        result.setId(event.getId());
        result.setEventType(EventType.JOIN);
        result.setEventTimeStamp(new Date());

        result.setCreateTime(event.getCreateTime());
        result.setDeliveryTime(new Date());
        result.setEndTime(UNDEFINED_TIME_STAMP);

        result.setServiceType(event.getServiceType());
        result.setOriginationPage(event.getOriginationPage());
        result.setOriginationChannel(event.getOriginationChannel());

        result.setAgentId(RandomUtil.generateAgentId());
        result.setEndReason(null);

        return result;
    }

    private Event generateEndEvent(Event event) {
        if (!event.getEventType().equals(EventType.JOIN)) {
            throw new IllegalArgumentException("Wrong event type");
        }

        Event result = new Event();

        result.setId(event.getId());
        result.setEventType(EventType.END);
        result.setEventTimeStamp(new Date());

        result.setCreateTime(event.getCreateTime());
        result.setDeliveryTime(event.getDeliveryTime());
        result.setEndTime(new Date());

        result.setServiceType(event.getServiceType());
        result.setOriginationPage(event.getOriginationPage());
        result.setOriginationChannel(event.getOriginationChannel());

        result.setAgentId(event.getAgentId());
        result.setEndReason((EndReason) RandomUtil.getRandomObjectFromArray(EndReason.values()));

        return result;
    }
}
