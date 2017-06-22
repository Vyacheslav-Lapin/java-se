package com.luxoft.training.javase.bankapp.domains;

import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.observer.ClientObserver;
import lombok.SneakyThrows;
import lombok.ToString;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Client> clients = new HashSet<>(CLIENTS_LENGTH);
    private int index;

    @SneakyThrows
    private void save() {
        try (FileOutputStream fis = new FileOutputStream("bank.ser");
             ObjectOutputStream ois = new ObjectOutputStream(fis)) {
            ois.writeObject(this);
        }
    }

    public Collection<Client> getClients() {
        return Collections.unmodifiableCollection(clients);
    }

    public void add(Client client) throws ClientExistsException {

        for (Client client1 : clients)
            if (client1.getFirstName().equals(client.getFirstName())
                    && client1.getLastName().equals(client.getLastName()))
                throw new ClientExistsException();

        clients.add(client);
        clientAdded(client);

        client.getAccounts().iterator().next()
                .addListener(
                (oldBalance, newBalance) ->
                        Bank.this.save()
        );
    }
}
