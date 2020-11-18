package com.example.challenge.tenpo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import com.example.challenge.tenpo.web.controllers.HomeController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class TenpoChallengeApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void shouldLoadContextWhenApplicationHasStarted() {

		// WHEN
		TenpoChallengeApplication.main(new String[] {});

		// EXPECT
		HomeController bean = context.getBean(HomeController.class);
		assertThat(bean, not(nullValue()));
	}

}
