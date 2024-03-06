package com.shubham;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
class JpaDemoApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Testing is Done");
		assertTrue(new Student());
		assertTrue(new Student(123, "Shubham", "abcd", True));
		assertTrue(new Student("Shubham", "abcd", True));
		assertTrue(new Student(1233 , "abcd", "True"));
	}

}
