package com.luxoft.training.javase.bankapp.domains.accounts;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
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
