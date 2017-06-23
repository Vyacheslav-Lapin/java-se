package com.luxoft.training.javase.bankapp.domains.clients;

import lombok.extern.log4j.Log4j2;

import java.util.LinkedList;
import java.util.Queue;

@Log4j2
public class EmailNotificationClientListener
        extends Thread
        implements ClientRegistrationListener {

    private volatile static EmailNotificationClientListener listener =
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

        synchronized (this) {
            notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            while (emails.size() > 0) {
                Email email = emails.poll();
                log.info(
                        "Notification email from {} to {} with theme {} and body {} to be sent",
                        email.getFrom(),
                        email.getTo(),
                        email.getTheme(),
                        email.getBody()
                );
            }
            synchronized (this) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
