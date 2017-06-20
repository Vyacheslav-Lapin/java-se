package com.luxoft.training.javase.bankapp.domains.accounts;

@FunctionalInterface
public interface AccountModificationListener {
    void accountModified(double oldBalance, double newBalance);
}
