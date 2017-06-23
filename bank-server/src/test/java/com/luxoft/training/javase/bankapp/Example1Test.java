package com.luxoft.training.javase.bankapp;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class Example1Test {

    public static final String FILE_NAME = "src/main/js/example1.js";

    @Test
    @SneakyThrows
    void name() {
        HashMap<String, String> variables = new HashMap<>();
        variables.put("y", "42");
        assertThat(
                Example1.executeScript(FILE_NAME,
                        variables)
                        .get("result"),
                is("21.0")
        );
    }
}