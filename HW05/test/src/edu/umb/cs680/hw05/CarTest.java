package edu.umb.cs680.hw05;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
	private String[] CarToStringArray(Car c) {
		String[] carInfo = { c.getMake(), c.getModel(), Integer.toString(c.getYear()) };
		return carInfo;
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = { "Kia", "Seltos", "2019" };
		Car actual = new Car("Kia", "Seltos", 28, 2019, 21000);
		assertArrayEquals(expected, CarToStringArray(actual));
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear_NotEqual() {
		String[] expected = { "Ford", "Ikon", "2008" };
		Car actual = new Car("Ford", "Ikon", 28, 2008, 17000);
		assertNotEquals(expected, CarToStringArray(actual));
	}

}
