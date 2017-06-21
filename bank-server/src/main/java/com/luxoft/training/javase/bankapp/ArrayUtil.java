package com.luxoft.training.javase.bankapp;

public class ArrayUtil {

    public static int indexOf(Object[] objects, Object object) {
        for (int i = 0; i < objects.length; i++)
            if (objects[i].equals(object))
                return i;
        return -1;
    }
}
