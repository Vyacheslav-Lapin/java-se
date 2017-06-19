package com.luxoft.training.javase.bankapp.domains;

import com.luxoft.training.javase.bankapp.domains.accounts.Account;
import com.luxoft.training.javase.bankapp.domains.accounts.CheckingAccount;
import com.luxoft.training.javase.bankapp.domains.accounts.NotEnoughFundsException;
import com.luxoft.training.javase.bankapp.domains.accounts.SavingAccount;
import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.domains.clients.EmailNotificationClientListener;
import com.luxoft.training.javase.bankapp.domains.clients.PrintClientListener;
import com.luxoft.training.javase.bankapp.service.BankService;
import org.junit.jupiter.api.Test;

import static com.luxoft.training.javase.bankapp.domains.Gender.FEMALE;
import static com.luxoft.training.javase.bankapp.domains.Gender.MALE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BankTest {

    @Test
    void getClients() throws CLientExistsException, NotEnoughFundsException {

        BankService.addListener(new PrintClientListener());
        BankService.addListener(new EmailNotificationClientListener());

        Client Jane = BankService.addClient(
                "Женя",
                "Петренко",
                MALE,
                1987, 3, 1,
                new CheckingAccount(50, 100));

        Client Sasha = BankService.addClient(
                "Саша",
                "Петренко",
                FEMALE,
                1983, 3, 1,
                new SavingAccount(150));

        Client Vasya = BankService.addClient(
                "Вася",
                "Петренко",
                FEMALE,
                1986, 3, 1,
                new CheckingAccount(250, 150));

        System.out.println(Bank.INSTANCE);

        modifyBank();

        for (Client client : Bank.INSTANCE.getClients()) {
            for (Account account : client.getAccounts()) {
                assertThat(account.getBalance(), is(0.0));
            }
        }

        System.out.println(Bank.INSTANCE);
    }

    private void modifyBank() throws NotEnoughFundsException {
        for (Client client : Bank.INSTANCE.getClients()) {
            for (Account account : client.getAccounts()) {
                account.withdraw(account.getBalance());
            }
        }
    }
}