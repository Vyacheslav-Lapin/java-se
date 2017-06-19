package com.luxoft.training.javase.bankapp.domains;

import lombok.Value;

import java.util.Date;

@Value
public class Client {
    private Account[] accounts;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;
}
