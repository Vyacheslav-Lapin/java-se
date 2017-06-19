package com.luxoft.training.javase.bankapp.domains.clients;

public class PrintClientListener implements ClientRegistrationListener {
    @Override
    public void onClientAdded(Client client) {
        System.out.printf("%s added!%n", client);
    }
}
