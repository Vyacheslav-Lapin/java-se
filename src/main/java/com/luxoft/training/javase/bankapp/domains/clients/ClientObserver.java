package com.luxoft.training.javase.bankapp.domains.clients;

import java.util.ArrayList;
import java.util.List;

public abstract class ClientObserver {

    private List<ClientRegistrationListener> listeners =
            new ArrayList<>();

    public void addListener(ClientRegistrationListener listener) {
        listeners.add(listener);
    }

    // TODO: 19/06/2017 realize CRUD for listeners

    public void clientAdded(Client client) {
        for (ClientRegistrationListener listener : listeners) {
            listener.onClientAdded(client);
        }
    }
}
