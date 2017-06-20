package com.luxoft.training.javase.bankapp.domains.accounts;

import java.io.Serializable;

public interface Account extends Serializable {
    double getBalance();

    long decimalValue();

    void deposit(double x);

    void withdraw(double x) throws NotEnoughFundsException;

    void addListener(AccountModificationListener listener);

    void deleteListener(AccountModificationListener listener);
}
