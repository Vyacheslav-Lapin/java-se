package com.luxoft.training.javase.bankapp.domains;

import com.luxoft.training.javase.bankapp.service.BankService;
import org.junit.jupiter.api.Test;

import static com.luxoft.training.javase.bankapp.domains.Gender.FEMALE;
import static com.luxoft.training.javase.bankapp.domains.Gender.MALE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BankTest {

    @Test
    void getClients() {

        Client Jane = BankService.addClient(
                "Женя",
                "Петренко",
                MALE,
                1987, 3, 1,
                new CheckingAccount(50));

        Client Sasha = BankService.addClient(
                "Саша",
                "Петренко",
                FEMALE,
                1983, 3, 1,
                new CheckingAccount(150));

        Client Vasya = BankService.addClient(
                "Вася",
                "Петренко",
                FEMALE,
                1986, 3, 1,
                new CheckingAccount(250));

        System.out.println(Bank.INSTANCE);

        modifyBank();

        for (Client client : Bank.INSTANCE.getClients()) {
            for (Account account : client.getAccounts()) {
                assertThat(account.getBalance(), is(0.0));
            }
        }

        System.out.println(Bank.INSTANCE);
    }

    private void modifyBank() {
        for (Client client : Bank.INSTANCE.getClients()) {
            for (Account account : client.getAccounts()) {
                account.withdraw(account.getBalance());
            }
        }
    }
}