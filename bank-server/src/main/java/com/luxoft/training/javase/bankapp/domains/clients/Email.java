package com.luxoft.training.javase.bankapp.domains.clients;

import lombok.Value;

@Value
public class Email {
    private String from;
    private String to;
    private String theme;
    private String body;
}
