package com.example.student_service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test() {
		Calculator calculator = new Calculator();
        int result = calculator.add(4, 5);
        assertEquals(9, result);  // Expected 4 + 5 = 9
	}
	
	@Test
	void test2() {
		Calculator calculator = new Calculator();
        int result = calculator.add(4, 5);
        assertEquals(10, result);  // Expected 4 + 5 = 9
	}

}
