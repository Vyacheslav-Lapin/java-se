package com.luxoft.training.javase.bankapp.domains;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SavingAccount implements Account {

    private double balance;

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
        if (x > 0 && x < balance)
            balance -= x;
    }
}
