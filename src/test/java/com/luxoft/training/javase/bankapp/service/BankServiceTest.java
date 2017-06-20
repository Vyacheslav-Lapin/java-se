package com.luxoft.training.javase.bankapp.service;

import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.domains.clients.ClientRegistrationListener;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BankServiceTest {
    @Test
    void main() {
        BankService.addListener(
                new ClientRegistrationListener() {
                    @Override
                    public void onClientAdded(Client client) {
                        System.out.println(client.getFirstName());
                    }
                });

        assertThat(
                fromSystemOut(new Runnable() {
                    @Override
                    public void run() {
                        BankService.main("–loadfeed", "src/test/resources/feed.csv");
                    }
                })
                , is("John\nJane\nAlex\n")
        );

    }

    @SuppressWarnings("unused")
    @SneakyThrows
    private static String fromSystemOut(Runnable runnable) {

        PrintStream realOut = System.out;

        try (val out = new ByteArrayOutputStream();
             val printStream = new PrintStream(out)) {

            System.setOut(printStream);
            runnable.run();

            return new String(out.toByteArray()).intern();

        } finally {
            System.setOut(realOut);
        }
    }
}