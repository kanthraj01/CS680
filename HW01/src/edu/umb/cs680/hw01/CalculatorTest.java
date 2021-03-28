package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public void addition7by2() {
		Calculator cut = new Calculator();
		float expected = 9f;
		float actual = cut.addition(7, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void subtract5by4() {
		Calculator cut = new Calculator();
		float expected = 1f;
		float actual = cut.subtraction(5, 4);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply5By8() {
		Calculator cut = new Calculator();
		float expected = 40;
		float actual = cut.multiply(5, 8);
		assertEquals(expected, actual);
	}

	@Test
	public void divide8By4() {
		Calculator cut = new Calculator();
		float expected = 2f;
		float actual = cut.divide(3, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void subtract1by5() {
		Calculator cut = new Calculator();
		try {
			cut.subtraction(1, 5);
			fail("X < Y");
		} catch (IllegalArgumentException ex) {
			assertEquals("X < Y", ex.getMessage());
		}
	}

	@Test
	public void divide7By0() {
		Calculator cut = new Calculator();
		try {
			cut.divide(7, 0);
			fail("Division by zero");
		} catch (IllegalArgumentException ex) {
			assertEquals("Division By Zero", ex.getMessage());
		}
	}
}