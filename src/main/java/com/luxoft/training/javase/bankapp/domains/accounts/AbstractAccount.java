package com.luxoft.training.javase.bankapp.domains.accounts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class AbstractAccount implements Account {

    protected double balance;

    /**
     * добавляет значение к балансу
     */
    @Override
    public void deposit(double x) {
        if (x > 0)
            balance += x;
        else throw new IllegalStateException();
    }

    @Override
    public void withdraw(double x) throws NotEnoughFundsException {
//        assert x > 0 && x <= availableFunds();
        if (x > 0 && x <= availableFunds())
            balance -= x;
        else throw new NotEnoughFundsException(x);
    }

    protected abstract double availableFunds();
}
