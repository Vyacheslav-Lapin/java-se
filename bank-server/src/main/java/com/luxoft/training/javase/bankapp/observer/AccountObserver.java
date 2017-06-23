package com.luxoft.training.javase.bankapp.observer;

import com.luxoft.training.javase.bankapp.domains.accounts.AccountModificationListener;

public abstract class AccountObserver extends Observer<AccountModificationListener> {

    protected void accountModified(double oldBalance, double newBalance) {
        for (AccountModificationListener listener : listeners) {
            listener.accountModified(oldBalance, newBalance);
        }
    }
}
