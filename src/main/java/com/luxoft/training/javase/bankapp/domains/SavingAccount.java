package com.luxoft.training.javase.bankapp.domains;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class SavingAccount extends AbstractAccount {

    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    protected double availableFunds() {
        return balance;
    }
}
