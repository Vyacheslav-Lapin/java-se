package com.luxoft.training.javase.bankapp.service;

import com.luxoft.training.javase.bankapp.ArrayUtil;
import com.luxoft.training.javase.bankapp.domains.Bank;
import com.luxoft.training.javase.bankapp.domains.ClientExistsException;
import com.luxoft.training.javase.bankapp.domains.Gender;
import com.luxoft.training.javase.bankapp.domains.accounts.Account;
import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.domains.clients.ClientRegistrationListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;

@Log4j2
public class BankService {

    public static Client addClient(String firstName, String lastName, Gender gender, int year, int month, int dayOfMonth, Account... accounts) {

        val client = new Client(
                new HashSet<>(Arrays.asList(accounts)),
                firstName,
                lastName,
                gender,
                new GregorianCalendar(year, month, dayOfMonth)
                        .getTime());

        try {
            log.info("Добавляем клиента {}", client);
            return addClient(client);
        } catch (ClientExistsException e) {
            return client;
        }
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
        if (args.length > 1
                && args[0].equals("–loadfeed")
                && new File(args[1]).exists())

            try (LineNumberReader reader = new LineNumberReader(
                    new BufferedReader(
                            new FileReader(args[1])))) {
                String line;
                while ((line = reader.readLine()) != null)
                    addClient(Client.parse(line));
            }

        if (ArrayUtil.indexOf(args, "-server") > -1)
            try (ServerSocket serverSocket = new ServerSocket(5432);
                 Socket socket = serverSocket.accept();
                 val writer = new PrintWriter(
                         socket.getOutputStream(), true);
                 val dataInputStream = new BufferedReader(
                         new InputStreamReader(
                                 socket.getInputStream()))) {
                String message = dataInputStream.readLine();
                if (message.startsWith("add ")) {
                    Client client = addClient(Client.parse(message.substring(4)));
                    writer.println(String.format("Client %s OK!", client));
                }
            }

    }
}
