package com.luxoft.training.javase.bankapp.domains.accounts;

import com.luxoft.training.javase.bankapp.domains.BankException;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class NotEnoughFundsException extends BankException {
    private double amount;
}
