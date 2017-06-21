package com.luxoft.training.javase.bankapp.domains.clients;

import com.luxoft.training.javase.bankapp.domains.Gender;
import com.luxoft.training.javase.bankapp.domains.accounts.Account;
import com.luxoft.training.javase.bankapp.domains.accounts.CheckingAccount;
import com.luxoft.training.javase.bankapp.domains.accounts.SavingAccount;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import static com.luxoft.training.javase.bankapp.domains.Gender.FEMALE;
import static com.luxoft.training.javase.bankapp.domains.Gender.MALE;
import static java.util.Arrays.deepToString;

@Value
public class Client implements Serializable {
    private Account[] accounts;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;

    @Override
    public String toString() {
        return String.format("Client %s %s %s (accounts=%s, dateOfBirth=%s)%n",
                getGender().getSalutation(),
                getFirstName(),
                getLastName(),
                deepToString(getAccounts()),
                getDateOfBirth());
    }

    public String getEmail() {
        return String.format("%s.%s@gmail.com",
                firstName,
                lastName);
    }

    // accounttype=c;balance=100;overdraft=50;name=John;gender=m
    public static Client parse(String s) {
        Properties properties = getAsProperties(s);

        Account[] accounts = {
                (properties.getProperty(
                        "accounttype",
                        properties.containsKey("overdraft") ? "c" : "s"
                ).equals("c")) ?
                        new CheckingAccount(
                                Double.parseDouble(properties.getProperty("balance")),
                                Double.parseDouble(properties.getProperty("overdraft"))
                        ) :
                        new SavingAccount(
                                Double.parseDouble(properties.getProperty("balance"))
                        )};

        Gender gender = properties.getProperty("gender", "m").equals("m") ? MALE : FEMALE;

        // TODO: 20/06/2017 Сделать разный дефолт по имени в зависимости от пола
        String firstName = properties.getProperty("firstName", "John");

        String lastName = properties.getProperty("lastName", "Doe");

        // TODO: 20/06/2017 добавить в формат
        Date dateOfBirth = new Date();

        return new Client(
                accounts,
                firstName,
                lastName,
                gender,
                dateOfBirth);
    }

    private static Properties getAsProperties(String s) {
        Properties properties = new Properties();
        for (String pair : s.split(";")) {
            String[] strings = pair.split("=");
            properties.setProperty(strings[0], strings[1]);
        }
        return properties;
    }
}
