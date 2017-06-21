package com.luxoft.training.javase.bankapp.domains.accounts;

import com.luxoft.training.javase.bankapp.observer.AccountObserver;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class AbstractAccount extends AccountObserver implements Account {

    protected double balance;

    @Override
    public long decimalValue() {
        return Math.round(balance);
    }

    /**
     * добавляет значение к балансу
     */
    @Override
    public void deposit(double x) {
        if (x > 0) {
            double oldBalance = balance;
            balance += x;
            accountModified(oldBalance, balance);
        }
        else throw new IllegalStateException();
    }
    @Override
    public void withdraw(double x) throws NotEnoughFundsException {
        if (x >= 0 && x <= availableFunds())
            accountModified(balance, balance -= x);
        else throw new NotEnoughFundsException(x);
    }

    protected abstract double availableFunds();
}
