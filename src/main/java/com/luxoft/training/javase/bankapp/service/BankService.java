package com.luxoft.training.javase.bankapp.service;

import com.luxoft.training.javase.bankapp.domains.Account;
import com.luxoft.training.javase.bankapp.domains.Bank;
import com.luxoft.training.javase.bankapp.domains.Client;
import com.luxoft.training.javase.bankapp.domains.Gender;

import java.util.GregorianCalendar;

public class BankService {

    public static Client addClient(String firstName, String lastName, Gender gender, int year, int month, int dayOfMonth, Account... accounts) {

        Client client = new Client(accounts,
                firstName,
                lastName,
                gender,
                new GregorianCalendar(year, month, dayOfMonth)
                        .getTime());

        Bank.INSTANCE.add(client);

        return client;
    }
}
