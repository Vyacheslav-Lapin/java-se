package com.luxoft.training.javase.bankapp.domains;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
}
