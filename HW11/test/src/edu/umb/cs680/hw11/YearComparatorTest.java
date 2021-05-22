package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;

class YearComparatorTest {
	LinkedList<Car> carsList = new LinkedList<Car>();

	@Test
	void verify_Year() {

		carList.add(new Car("Honda", "accord", 2019, 260, 25000));
		carList.add(new Car("Kia", "celtos", 2018, 300, 38000));
		carList.add(new Car("BMW", "xclass", 2016, 20, 23000));

		Collections.sort(carsList, new YearComparator());

		assertEquals(2018, carsList.get(0).getYear());
		assertEquals(2019, carsList.get(1).getYear());
		assertEquals(2020, carsList.get(2).getYear());

	}

}
