package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class MileageComparatorTest {
	LinkedList<Car> carList = new LinkedList<Car>();

	@Test
	public void checkMileageComparator() {
		carList.add(new Car("Honda", "accord", 2019, 260, 25000));
		carList.add(new Car("Kia", "celtos", 2018, 300, 38000));
		carList.add(new Car("BMW", "xclass", 2016, 20, 23000));
		Collections.sort(carList, new MileageComparator());

		assertEquals(16, carList.get(0).getMileage());
		assertEquals(10, carList.get(1).getMileage());
		assertEquals(8, carList.get(2).getMileage());

	}

}
