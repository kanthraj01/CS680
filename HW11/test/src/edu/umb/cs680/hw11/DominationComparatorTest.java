package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DominationComparator_Test {

	static LinkedList<Car> carList = new LinkedList<Car>();

	@BeforeAll
	public static void initialize() {
		Car car1 = new Car("Ferrari", "MOTO1", 2001, 12000, 11000);
		Car car2 = new Car("Audi", "ACLASS", 2021, 38000, 28000);
		Car car3 = new Car("Lamborgini", "HURRICANE", 2018, 32000, 19000);
		Car car4 = new Car("Ferrari", "MOTO2", 2002, 27000, 11000);
		Car car5 = new Car("Kia", "SELTOS", 2020, 30000, 23000);
		Car car6 = new Car("Kia", "CELRA", 2021, 20000, 12000);
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);
		carList.add(car5);
		carList.add(car6);
		carList.sort(new ParetoComparator());
	}

	@Test
	void checkCar1_AfterSort() {
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(5, carList.get(0).getDominationCount());
	}

	@Test
	void checkCar2_AfterSort() {
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(4, carList.get(1).getDominationCount());
	}

	@Test
	void checkCar3_AfterSort() {
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(3, carList.get(2).getDominationCount());
	}

	@Test
	void checkCar4_AfterSort() {
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(2, carList.get(3).getDominationCount());
	}

	@Test
	void checkCar5_AfterSort() {
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(1, carList.get(4).getDominationCount());
	}

	@Test
	void checkCar6_AfterSort() {
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).setDominationCount(i);
		}
		carList.sort(new DominationComparator());
		assertSame(0, carList.get(5).getDominationCount());
	}

}