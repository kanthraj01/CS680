package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class ParetoComparatorTest {
	static LinkedList<Car> carList = new LinkedList<Car>();

	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Ferrari", "MOTO1", 2001, 12000, 11000);
		Car car2 = new Car("Audi", "ACLASS", 2021, 38000, 28000);
		Car car3 = new Car("Lamborgini", "HURRICANE", 2018, 32000, 19000);

		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
	}

	@Test
	void checkCar1_AfterSort() {
		Car car1 = new Car("Ferrari", "MOTO1", 2001, 12000, 11000);
		carList.sort(new MileageComparator());
		assertEquals(car1, carList.get(2));
	}

	@Test
	void checkCar2_AfterSort() {
		Car car2 = new Car("Audi", "ACLASS", 2021, 38000, 28000);
		carList.sort(new MileageComparator());
		assertEquals(car2, carList.get(0));
	}

	@Test
	void checkCar3_AfterSort() {
		Car car3 = new Car("Lamborgini", "HURRICANE", 2018, 32000, 19000);
		carList.sort(new MileageComparator());
		assertEquals(car3, carList.get(1));
	}

}
