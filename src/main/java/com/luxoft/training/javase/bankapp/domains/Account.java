package com.luxoft.training.javase.bankapp.domains;

public interface Account {
    double getBalance();

    void deposit(double x);

    void withdraw(double x);
}
