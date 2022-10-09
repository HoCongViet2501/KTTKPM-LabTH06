package com.se.springboot_activemq.controller;

import com.se.springboot_activemq.jms.JmsProducer;
import com.se.springboot_activemq.model.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
    
    @Autowired
    JmsProducer jmsProducer;
    
    @PostMapping("/publishMessage")
    public ResponseEntity<Object> sendMessage(@RequestBody SystemMessage systemMessage) {
        jmsProducer.sendMessage(systemMessage);
        return ResponseEntity.ok().body(systemMessage);
    }
}
