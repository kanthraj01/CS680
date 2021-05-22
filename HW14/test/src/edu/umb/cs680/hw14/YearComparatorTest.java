package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class YearComparatorTest {
	static LinkedList<Car> carList = new LinkedList<Car>();

	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Ferrari", "MOTO1", 2001, 12000, 11000);
		Car car2 = new Car("Audi", "ACLASS", 2021, 38000, 28000);
		Car car3 = new Car("Lamborgini", "HURRICANE", 2018, 32000, 19000);
		Car car4 = new Car("Ferrari", "MOTO2", 2002, 27000, 11000);
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);
		Collections.sort(carList, (Car arg0, Car arg1) -> arg0.getYear() - arg1.getYear());
	}

	@Test
	void checkCar1AfterSort() {
		Car car1 = new Car("Ferrari", "MOTO1", 2001, 12000, 11000);
		assertEquals(car1, carList.get(3));
	}

	@Test
	void checkCar2AfterSort() {
		Car car2 = new Car("Audi", "ACLASS", 2021, 38000, 28000);
		assertEquals(car2, carList.get(0));
	}

	@Test
	void checkCar3AfterSort() {
		Car car3 = new Car("Lamborgini", "HURRICANE", 2018, 32000, 19000);
		assertEquals(car3, carList.get(1));
	}

	@Test
	void checkCar4AfterSort() {
		Car car4 = new Car("Ferrari", "MOTO2", 2002, 27000, 11000);
		assertEquals(car4, carList.get(2));
	}

}
