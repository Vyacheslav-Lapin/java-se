package com.luxoft.training.javase.bankapp.service;

import com.luxoft.training.javase.bankapp.domains.Bank;
import com.luxoft.training.javase.bankapp.domains.accounts.Account;
import com.luxoft.training.javase.bankapp.domains.clients.Client;

import java.util.*;

public class BankReport {

    public static int getCustomersQuantity() {
        return Bank.INSTANCE.getClients().size();
    }

    public static int getAccountsQuantity() {
        long sum = 0L;
        for (Client client : Bank.INSTANCE.getClients()) {
            Set<Account> accounts = client.getAccounts();
            long size = accounts.size();
            sum += size;
        }
        return (int) sum;
    }

    public static SortedSet<Account> getAccountsSortedBySum() {
        TreeSet<Account> accounts =
                new TreeSet<>(Comparator.comparingDouble(
                        Account::getBalance));

        for (Client client : Bank.INSTANCE.getClients())
            accounts.addAll(client.getAccounts());

        return accounts;
    }

    public static double getBankCredit() {
        double result = 0.0;
        for (Client client : Bank.INSTANCE.getClients())
            for (Account account : client.getAccounts()) {
                double balance = account.getBalance();
                if (balance < 0)
                    result += -balance;
            }
        return result;
    }

    public static Map<Client, Set<Account>> getCustomerAccount() {
        Map<Client, Set<Account>> result = new HashMap<>();

        for (Client client : Bank.INSTANCE.getClients())
            result.put(client, client.getAccounts());

        return result;
    }
}
