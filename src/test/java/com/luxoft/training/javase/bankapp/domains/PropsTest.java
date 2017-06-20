package com.luxoft.training.javase.bankapp.domains;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PropsTest {

    @Test
    void propsWorksGood() throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream =
                     new FileInputStream("src/main/resources/props.properties")) {
            properties.load(inputStream);
        }

        assertThat(properties.getProperty("key"), is("value"));
        assertThat(properties.getProperty("key2"), is("value2"));
    }

    @SuppressWarnings("unused")
    @SneakyThrows
    private static String fromSystemOut(Runnable runnable) {

        PrintStream realOut = System.out;

        try (val out = new ByteArrayOutputStream();
             val printStream = new PrintStream(out)) {

            System.setOut(printStream);
            runnable.run();

            return new String(out.toByteArray()).intern();

        } finally {
            System.setOut(realOut);
        }
    }
}
