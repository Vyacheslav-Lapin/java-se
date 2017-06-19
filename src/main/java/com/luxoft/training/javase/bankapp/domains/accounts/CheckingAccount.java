package com.luxoft.training.javase.bankapp.domains.accounts;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class CheckingAccount extends AbstractAccount {

    private double overdraft;

    public CheckingAccount(double balance, double overdraft) {
        super(balance);
        this.overdraft = overdraft;
    }

    @Override
    protected double availableFunds() {
        return balance + overdraft;
    }
}
