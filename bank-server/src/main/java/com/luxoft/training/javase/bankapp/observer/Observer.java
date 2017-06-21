package com.luxoft.training.javase.bankapp.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observer<L> {
    protected List<L> listeners = new ArrayList<>();

    public void addListener(L listener) {
        listeners.add(listener);
    }

    public void deleteListener(L listener) {
        listeners.remove(listener);
    }
}
