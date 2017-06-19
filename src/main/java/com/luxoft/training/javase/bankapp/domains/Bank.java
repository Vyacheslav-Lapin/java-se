package com.luxoft.training.javase.bankapp.domains;

import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.domains.clients.ClientObserver;
import lombok.ToString;

@ToString
public class Bank extends ClientObserver {
    public static Bank INSTANCE = new Bank();
    private Bank(){
    }

    public static final int CLIENTS_LENGTH = 10;
    private Client[] clients = new Client[CLIENTS_LENGTH];
    private int index;

    public Client[] getClients() {
        Client[] result = new Client[index];

        System.arraycopy(
                clients,
                0,
                result,
                0,
                index);

        return result;
    }

    public int add(Client client) throws CLientExistsException {

        for (int i = 0; i < index; i++) {
            Client client1 = clients[i];
            if (client1.getFirstName().equals(client.getFirstName())
                    && client1.getLastName().equals(client.getLastName()))
                throw new CLientExistsException();
        }

        if (index < clients.length) {
            clients[index++] = client;
            clientAdded(client);
        }

        return index - 1;
    }
}
