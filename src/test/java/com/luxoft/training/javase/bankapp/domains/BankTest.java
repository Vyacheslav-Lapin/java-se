package com.luxoft.training.javase.bankapp.domains;

import lombok.experimental.var;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static com.luxoft.training.javase.bankapp.domains.Gender.FEMALE;
import static com.luxoft.training.javase.bankapp.domains.Gender.MALE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BankTest {

    @Test
    void getClients() {
        var bank = new Bank(new Client[]{

                new Client(new Account[]{new CheckingAccount(50)},
                        "Женя",
                        "Петренко",
                        MALE,
                        new GregorianCalendar(1987, 3, 1)
                                .getTime()),

                new Client(new Account[]{new CheckingAccount(150)},
                        "Саша",
                        "Петренко",
                        FEMALE,
                        new GregorianCalendar(1983, 3, 1)
                                .getTime()),

                new Client(new Account[]{new CheckingAccount(250)},
                        "Вася",
                        "Петренко",
                        FEMALE,
                        new GregorianCalendar(1986, 3, 1)
                                .getTime()),

                new Client(new Account[]{new CheckingAccount(5)},
                        "Света",
                        "Петренко",
                        FEMALE,
                        new GregorianCalendar(1984, 3, 1)
                                .getTime()),

                new Client(new Account[]{new CheckingAccount(350)},
                        "Дима",
                        "Петренко",
                        MALE,
                        new GregorianCalendar(1985, 3, 1)
                                .getTime()),

                new Client(new Account[]{new CheckingAccount(500)},
                        "Макс",
                        "Петренко",
                        MALE,
                        new GregorianCalendar(1989, 3, 1)
                                .getTime())
        });

        System.out.println(bank);

        modifyBank(bank);

        for (Client client : bank.getClients()) {
            for (Account account : client.getAccounts()) {
                assertThat(account.getBalance(), is(0.0));
            }
        }

        System.out.println(bank);
    }

    private void modifyBank(Bank bank) {
        for (Client client : bank.getClients()) {
            for (Account account : client.getAccounts()) {
                account.withdraw(account.getBalance());
            }
        }
    }
}