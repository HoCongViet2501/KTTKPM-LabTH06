package com.se.springboot_activemq.jms;

import com.se.springboot_activemq.model.SystemMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Slf4j
@Component
public class JmsConsumer implements MessageListener {
    @Override
    @JmsListener(destination = "topic-queue")
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            SystemMessage systemMessage = (SystemMessage) objectMessage.getObject();
            log.info("Receive message from topic: " + systemMessage.toString());
        } catch (JMSException e) {
            log.error(e.getMessage());
        }
    }
}
