package com.luxoft.training.javase.bankapp.domains;

import lombok.experimental.var;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BankTest {

    @Test
    void getClients() {
        var bank = new Bank(new Client[]{
                new Client(new Account[]{new CheckingAccount(50)}),
                new Client(new Account[]{new CheckingAccount(150)}),
                new Client(new Account[]{new CheckingAccount(250)}),
                new Client(new Account[]{new CheckingAccount(5)}),
                new Client(new Account[]{new CheckingAccount(350)}),
                new Client(new Account[]{new CheckingAccount(500)}),
                new Client(new Account[]{new CheckingAccount(550)}),
                new Client(new Account[]{new CheckingAccount(20)}),
                new Client(new Account[]{new CheckingAccount(15)}),
                new Client(new Account[]{new CheckingAccount(0)}),
        });

        modifyBank(bank);

        for (Client client : bank.getClients()) {
            for (Account account : client.getAccounts()) {
                assertThat(account.getBalance(), is(0.0));
            }
        }
    }

    private void modifyBank(Bank bank) {
        for (Client client : bank.getClients()) {
            for (Account account : client.getAccounts()) {
                account.withdraw(account.getBalance());
            }
        }
    }
}