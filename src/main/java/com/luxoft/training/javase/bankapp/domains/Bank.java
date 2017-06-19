package com.luxoft.training.javase.bankapp.domains;

import lombok.ToString;

@ToString
public enum  Bank {
    INSTANCE;

    public static final int CLIENTS_LENGTH = 10;
    private Client[] clients = new Client[CLIENTS_LENGTH];
    private int index;

    public Client[] getClients() {

        Client[] result = new Client[index];

        System.arraycopy(clients, 0, result, 0, index);

        return result;
    }

    public int add(Client client) {
        if (index < clients.length)
            clients[index++] = client;

        return index - 1;
    }

//    private Bank() {
//    }
//
//    private volatile static Bank bank;
//
//    public static Bank getInstance() {
//        if (bank == null)
//            synchronized (Bank.class) {
//                if (bank == null)
//                    bank = new Bank();
//            }
//        return bank;
//    }
}
