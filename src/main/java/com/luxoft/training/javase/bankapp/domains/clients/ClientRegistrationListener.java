package com.luxoft.training.javase.bankapp.domains.clients;

@FunctionalInterface
public interface ClientRegistrationListener {
    void onClientAdded(Client client);
}
