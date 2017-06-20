package com.luxoft.training.javase.bankapp.domains.accounts;

public interface Account {
    double getBalance();

    long decimalValue();

    void deposit(double x);

    void withdraw(double x) throws NotEnoughFundsException;
}
