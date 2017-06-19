package com.luxoft.training.javase.bankapp.domains.accounts;

public interface Account {
    double getBalance();

    void deposit(double x);

    void withdraw(double x) throws NotEnoughFundsException;
}
