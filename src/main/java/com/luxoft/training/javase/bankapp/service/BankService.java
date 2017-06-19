package com.luxoft.training.javase.bankapp.service;

import com.luxoft.training.javase.bankapp.domains.CLientExistsException;
import com.luxoft.training.javase.bankapp.domains.accounts.Account;
import com.luxoft.training.javase.bankapp.domains.Bank;
import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.domains.Gender;
import com.luxoft.training.javase.bankapp.domains.clients.ClientRegistrationListener;

import java.util.GregorianCalendar;

public class BankService {

    public static Client addClient(String firstName, String lastName, Gender gender, int year, int month, int dayOfMonth, Account... accounts) throws CLientExistsException {

        Client client = new Client(accounts,
                firstName,
                lastName,
                gender,
                new GregorianCalendar(year, month, dayOfMonth)
                        .getTime());

        Bank.INSTANCE.add(client);

        return client;
    }

    public static void addListener(ClientRegistrationListener listener) {
        Bank.INSTANCE.addListener(listener);
    }
}
