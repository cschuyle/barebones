package org.example;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    @Test
    void shouldPass() {
        assertTrue(true);
        assertThat(true, equalTo(true));
    }

    @Test
    void shouldFail() {
        assertThat(42, equalTo(2001));
    }

}
