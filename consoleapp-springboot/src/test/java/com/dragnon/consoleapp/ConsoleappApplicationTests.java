package com.dragnon.consoleapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
class ConsoleappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void shouldFail() {
		assertThat("morning", containsString("night"));
	}

}
