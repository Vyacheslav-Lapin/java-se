package com.luxoft.training.javase.bankapp.domains;

import lombok.Value;

import java.util.Date;

import static java.util.Arrays.deepToString;

@Value
public class Client {
    private Account[] accounts;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;

    @Override
    public String toString() {
        return String.format("Client %s %s %s (accounts=%s, dateOfBirth=%s)%n",
                getGender().getSalutation(),
                getFirstName(),
                getLastName(),
                deepToString(getAccounts()),
                getDateOfBirth());
    }
}
