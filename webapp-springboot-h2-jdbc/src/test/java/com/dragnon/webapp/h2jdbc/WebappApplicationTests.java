package com.dragnon.webapp.h2jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class WebappApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void shouldFail() {
		assertThat(true, equalTo(false));
	}

}
