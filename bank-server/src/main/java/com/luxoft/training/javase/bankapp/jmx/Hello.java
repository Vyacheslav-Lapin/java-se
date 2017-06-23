package com.luxoft.training.javase.bankapp.jmx;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hello implements HelloMBean {
    private String message;

    public Hello() {
        message = "Hello, world";
    }

    public void sayHello() {
        System.out.println(message);
    }
}
