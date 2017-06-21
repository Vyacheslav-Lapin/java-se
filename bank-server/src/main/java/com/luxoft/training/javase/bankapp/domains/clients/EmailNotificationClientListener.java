package com.luxoft.training.javase.bankapp.domains.clients;

public class EmailNotificationClientListener implements ClientRegistrationListener {
    @Override
    public void onClientAdded(Client client) {
        System.out.printf("Notification email for client %s %s %s to be sent.%n",
                client.getGender().getSalutation(),
                client.getFirstName(),
                client.getLastName());
    }
}
