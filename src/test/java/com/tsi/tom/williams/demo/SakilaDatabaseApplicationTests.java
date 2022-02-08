package com.tsi.tom.williams.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SakilaDatabaseApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testTesting(){
		boolean testReturn = SakilaDatabaseApplication.testTest();
		assertEquals(true, testReturn,"Test didnt return expected boolean.");
	}

}
