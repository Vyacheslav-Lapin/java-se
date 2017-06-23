package com.luxoft.training.javase.bankapp.domains;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * This annotation is used for mark file name of
 * serialized object.
 */
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Serialized {
    String value();
}
