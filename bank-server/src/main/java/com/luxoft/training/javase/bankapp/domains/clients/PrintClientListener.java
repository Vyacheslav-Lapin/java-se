package com.luxoft.training.javase.bankapp.domains.clients;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PrintClientListener implements ClientRegistrationListener {
    @Override
    public void onClientAdded(Client client) {
        log.info("{} added", client);
    }
}
