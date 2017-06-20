package com.luxoft.training.javase.bankapp.domains.accounts;

import com.luxoft.training.javase.bankapp.domains.BankException;
import lombok.Value;

@Value
public class NotEnoughFundsException extends BankException {
    private double amount;
}
