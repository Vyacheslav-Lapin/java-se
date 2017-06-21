package com.luxoft.training.javase.bankapp.client;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BankClientTest {
    @Test
    void getFromServer() {
        String fromServer = BankClient.getFromServer("add accounttype=c;balance=100;overdraft=50;firstName=John;lastName=Doe;gender=m")
                .substring(0, 37);
        assertThat(fromServer, is("Client Client Mr. John Doe (accounts="));
    }

}