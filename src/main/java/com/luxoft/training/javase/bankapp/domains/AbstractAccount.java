package com.luxoft.training.javase.bankapp.domains;

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
    }

    @Override
    public void withdraw(double x) {
        if (x > 0 && x <= availableFunds())
            balance -= x;
    }

    protected abstract double availableFunds();
}
