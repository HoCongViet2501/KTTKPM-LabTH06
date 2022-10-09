package com.se.springboot_activemq.jms;

import com.se.springboot_activemq.model.SystemMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsProducer {
    
    @Autowired
    JmsTemplate jmsTemplate;
    
    private final static String topic = "topic-queue";
    
    public void sendMessage(SystemMessage systemMessage) {
        try {
            log.info("Send message to topic: " + topic);
            jmsTemplate.convertAndSend(topic, systemMessage);
        }catch (Exception e){
            log.error("Error: "+e.getMessage());
        }
    }
}
