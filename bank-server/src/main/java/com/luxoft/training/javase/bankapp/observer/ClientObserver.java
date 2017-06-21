package com.luxoft.training.javase.bankapp.observer;

import com.luxoft.training.javase.bankapp.domains.clients.Client;
import com.luxoft.training.javase.bankapp.domains.clients.ClientRegistrationListener;

public abstract class ClientObserver extends Observer<ClientRegistrationListener> {
    protected void clientAdded(Client client) {
        for (ClientRegistrationListener listener : listeners) {
            listener.onClientAdded(client);
        }
    }
}
