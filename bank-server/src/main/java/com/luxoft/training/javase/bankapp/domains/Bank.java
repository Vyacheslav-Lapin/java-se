package com.luxoft.training.javase.bankapp.domains;

import com.luxoft.training.javase.bankapp.domains.accounts.AccountModificationListener;
import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.observer.ClientObserver;
import lombok.SneakyThrows;
import lombok.ToString;

import java.io.*;

@ToString
public class Bank extends ClientObserver implements Serializable {
    public static final Bank INSTANCE;
    private static final String BANK_SERIALIZED_FILE_NAME =
            "bank.ser";

    static {
        if (new File(BANK_SERIALIZED_FILE_NAME).exists())
            try (FileInputStream fis = new FileInputStream("bank.ser");
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                INSTANCE = (Bank) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        else
            INSTANCE = new Bank();
    }

    private Bank() {
    }

    public static final int CLIENTS_LENGTH = 10;
    private Client[] clients = new Client[CLIENTS_LENGTH];
    private int index;

    @SneakyThrows
    private void save() {
        try (FileOutputStream fis = new FileOutputStream("bank.ser");
             ObjectOutputStream ois = new ObjectOutputStream(fis)) {
            ois.writeObject(this);
        }
    }

    public Client[] getClients() {
        Client[] result = new Client[index];

        System.arraycopy(clients, 0, result, 0, index);

        return result;
    }

    public int add(Client client) throws ClientExistsException {

        for (int i = 0; i < index; i++) {
            Client client1 = clients[i];
            if (client1.getFirstName().equals(client.getFirstName())
                    && client1.getLastName().equals(client.getLastName()))
                throw new ClientExistsException();
        }

        if (index < clients.length) {
            clients[index++] = client;
            clientAdded(client);
        }

        client.getAccounts()[0].addListener(
                new AccountModificationListener() {
                    @Override
                    public void accountModified(double oldBalance, double newBalance) {
                        Bank.this.save();
                    }
                }
        );

        return index - 1;
    }
}
