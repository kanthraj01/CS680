package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class PriceComparatorTest {

	LinkedList<Car> carsList = new LinkedList<Car>();

	@Test
	void verify_Price() {

		carList.add(new Car("Honda", "accord", 2019, 260, 25000));
		carList.add(new Car("Kia", "celtos", 2018, 300, 38000));
		carList.add(new Car("BMW", "xclass", 2016, 20, 23000));

		Collections.sort(carsList, new PriceComparator());

		assertEquals(165000, carsList.get(0).getPrice());
		assertEquals(85000, carsList.get(1).getPrice());
		assertEquals(65000, carsList.get(2).getPrice());

	}
}
