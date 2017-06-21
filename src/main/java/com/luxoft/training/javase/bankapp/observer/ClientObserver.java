package com.luxoft.training.javase.bankapp.observer;

import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.domains.clients.ClientRegistrationListener;

import java.util.ArrayList;
import java.util.List;

public abstract class ClientObserver {

    private List<ClientRegistrationListener> listeners =
            new ArrayList<>();

    public void addListener(ClientRegistrationListener listener) {
        listeners.add(listener);
    }

    public void deleteListener(ClientRegistrationListener listener) {
        listeners.remove(listener);
    }

    public void clientAdded(Client client) {
        for (ClientRegistrationListener listener : listeners) {
            listener.onClientAdded(client);
        }
    }
}
