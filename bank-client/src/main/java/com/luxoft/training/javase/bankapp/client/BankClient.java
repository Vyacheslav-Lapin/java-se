package com.luxoft.training.javase.bankapp.client;

import lombok.SneakyThrows;
import lombok.val;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BankClient {
    // TODO: 21/06/2017 сделать reusable
    @SneakyThrows
    public static String getFromServer(String commands) {
        try (Socket socket = new Socket("127.0.0.1", 5432);
             val writer = new PrintWriter(socket.getOutputStream(), true);
             val reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {
            writer.println(commands);
            return reader.readLine();
        }
    }
}
