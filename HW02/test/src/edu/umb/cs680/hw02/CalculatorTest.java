package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw02.Calculator;

class CalculatorTest {

	@Test
	public void Multiply_2And4() throws Exception {
		Calculator calculator = new Calculator();
		double number = calculator.Multiply(2, 4);
		assertEquals(8, number);
	}

	@Test
	public void Multiply_0And0() throws Exception {
		Calculator calculator = new Calculator();
		double number = calculator.Multiply(0, 0);
		assertEquals(0, number);
	}

	@Test
	public void Multiply_MinusAndMinus() throws Exception {
		Calculator calculator = new Calculator();
		double number = calculator.Multiply(-3, -8);
		assertEquals(24, number);
	}

	@Test
	public void Division_6And2() throws Exception {
		Calculator calculator = new Calculator();
		double number = calculator.Division(6, 2);
		assertEquals(3, number);

	}

	@Test
	public void Division_MinusAndMinus() throws Exception {
		Calculator calculator = new Calculator();
		double number = calculator.Division(-6, -2);
		assertEquals(3, number);

	}

	@Test
	public void Division_MinusAndPositive() throws Exception {
		Calculator calculator = new Calculator();
		double number = calculator.Division(-6, 3);
		assertEquals(-2, number);

	}

	@Test
	public void Division_7By0() throws Exception {
		Calculator calculator = new Calculator();
		try {
			calculator.Division(7, 0);
			fail("Undefined!!");
		} catch (IllegalArgumentException ex) {
			assertEquals("Undefined", ex.getMessage());
		}
	}
}
