package com.luxoft.training.javase.bankapp.domains;

import lombok.Value;

@Value
public class Client {
    private Account[] accounts;
}
