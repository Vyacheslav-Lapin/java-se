package com.luxoft.training.javase.bankapp.service;

import com.luxoft.training.javase.bankapp.domains.Bank;
import com.luxoft.training.javase.bankapp.domains.ClientExistsException;
import com.luxoft.training.javase.bankapp.domains.Gender;
import com.luxoft.training.javase.bankapp.domains.accounts.Account;
import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.domains.clients.ClientRegistrationListener;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.GregorianCalendar;

public class BankService {

    public static Client addClient(String firstName, String lastName, Gender gender, int year, int month, int dayOfMonth, Account... accounts) throws ClientExistsException {

        Client client = new Client(accounts,
                firstName,
                lastName,
                gender,
                new GregorianCalendar(year, month, dayOfMonth)
                        .getTime());

        return addClient(client);
    }

    private static Client addClient(Client client) throws ClientExistsException {
        Bank.INSTANCE.add(client);

        return client;
    }

    public static void addListener(ClientRegistrationListener listener) {
        Bank.INSTANCE.addListener(listener);
    }

    public static void removeListener(ClientRegistrationListener listener) {
        Bank.INSTANCE.deleteListener(listener);
    }

    @SneakyThrows
    public static void main(String... args) {
        if (args.length < 2
                || !args[0].equals("–loadfeed")
                || !new File(args[1]).exists())
            return;

        try (LineNumberReader reader = new LineNumberReader(
                new BufferedReader(
                        new FileReader(args[1])))) {
            String line;
            while ((line = reader.readLine()) != null)
                addClient(Client.parse(line));
        }
    }
}
