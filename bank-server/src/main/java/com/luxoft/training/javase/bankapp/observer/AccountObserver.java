package com.luxoft.training.javase.bankapp.observer;

import com.luxoft.training.javase.bankapp.domains.accounts.AccountModificationListener;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountObserver {
    private List<AccountModificationListener> listeners =
            new ArrayList<>();

    public void addListener(AccountModificationListener listener) {
        listeners.add(listener);
    }

    public void deleteListener(AccountModificationListener listener) {
        listeners.remove(listener);
    }

    protected void accountModified(double oldBalance, double newBalance) {
        for (AccountModificationListener listener : listeners) {
            listener.accountModified(oldBalance, newBalance);
        }
    }
}
