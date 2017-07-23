package com.savelev.generator;

import com.savelev.generator.enums.EndReason;
import com.savelev.generator.enums.EventType;
import com.savelev.generator.enums.OriginationChannel;
import com.savelev.generator.enums.OriginationPage;
import com.savelev.generator.enums.ServiceType;

import java.util.Date;
import java.util.UUID;

/**
 * @author Artem Savelev (Artem.Savelev@lanit-tercom.com) created on 23.07.2017 10:28.
 */
public class Event {
    private UUID id;
    private EventType eventType;
    private Date eventTimeStamp;
    private Date createTime;
    private Date deliveryTime;
    private Date endTime;
    private ServiceType serviceType;
    private OriginationPage originationPage;
    private OriginationChannel originationChannel;
    private String agentId;
    private EndReason endReason;

    //would make sense to add lombok to get rid of getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Date getEventTimeStamp() {
        return eventTimeStamp;
    }

    public void setEventTimeStamp(Date eventTimeStamp) {
        this.eventTimeStamp = eventTimeStamp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public OriginationPage getOriginationPage() {
        return originationPage;
    }

    public void setOriginationPage(OriginationPage originationPage) {
        this.originationPage = originationPage;
    }

    public OriginationChannel getOriginationChannel() {
        return originationChannel;
    }

    public void setOriginationChannel(OriginationChannel originationChannel) {
        this.originationChannel = originationChannel;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public EndReason getEndReason() {
        return endReason;
    }

    public void setEndReason(EndReason endReason) {
        this.endReason = endReason;
    }
}
