package com.se.springboot_activemq.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SystemMessage implements Serializable {
    private String source;
    private String message;
}
