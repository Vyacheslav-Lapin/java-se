package com.luxoft.training.javase.bankapp.domains;

import lombok.Value;

@Value
public class Bank {
    private Client[] clients;

//    public String printBalance() {
//        val stringBuffer = new StringBuilder();
//        for (Client client : getClients()) {
//            for (Account account : client.getAccounts()) {
//                stringBuffer.append(account);
//            }
//        }
//        return stringBuffer.toString();
//    }
}
