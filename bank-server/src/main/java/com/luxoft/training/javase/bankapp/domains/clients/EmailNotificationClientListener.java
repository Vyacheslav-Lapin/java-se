package com.luxoft.training.javase.bankapp.domains.clients;

import java.util.LinkedList;
import java.util.Queue;

public class EmailNotificationClientListener
        extends Thread
        implements ClientRegistrationListener {

    private static EmailNotificationClientListener listener =
            new EmailNotificationClientListener();

    private EmailNotificationClientListener(){}

    public static EmailNotificationClientListener getInstance(){
        return listener;
    }

    static {
        listener.start();
    }

    private Queue<Email> emails = new LinkedList<>();

    @Override
    public void onClientAdded(Client client) {

        emails.add(new Email(
                "noreply@our-bank.ru",
                client.getEmail(),
                "Вас добавили!!! :)",
                "Вашу учётку наконец-то завели в нашем замечательном банке!\n" +
                        "Где получили карту - туда и идите!"));
    }

    @Override
    public void run() {
        while (true) {
            while (emails.size() > 0) {
                Email email = emails.poll();
                System.out.printf(
                        "Notification email from %s to %s with theme %s and body %s to be sent.%n",
                        email.getFrom(),
                        email.getTo(),
                        email.getTheme(),
                        email.getBody()
                );
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
