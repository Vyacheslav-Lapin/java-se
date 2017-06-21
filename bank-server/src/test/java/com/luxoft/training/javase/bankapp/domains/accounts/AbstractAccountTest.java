package com.luxoft.training.javase.bankapp.domains.accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class AbstractAccountTest {

    Account account;

    @BeforeEach
    void setUp() {
        account = new SavingAccount(50);
    }

    @Test
    void decimalValue() {
        assertThat(account.decimalValue(), is(50L));
    }

}