package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

	@Test
	public void primeGenerator11to20() {
		PrimeGenerator pgen = new PrimeGenerator(1, 10);
		pgen.generatePrimes();
		Long[] expectedPrimes = { 11L, 13L, 17L, 19L };
		assertArrayEquals(expectedPrimes, pgen.getPrimes().toArray());
	}

	@Test
	public void primeGenerator50to60() {
		PrimeGenerator pgen = new PrimeGenerator(40, 50);
		pgen.generatePrimes();
		Long[] expectedPrimes = { 53L, 59L };
		assertArrayEquals(expectedPrimes, pgen.getPrimes().toArray());
	}

	@Test
	public void primeGenerator10to10() {
		long from = 10;
		long to = 10;
		try {

			PrimeGenerator pgen = new PrimeGenerator(from, to);
			pgen.generatePrimes();
			Long[] expectedPrimes = {};
			assertArrayEquals(expectedPrimes, pgen.getPrimes().toArray());
		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=" + from + " to=" + to, ex.getMessage());
		}

	}

	@Test
	public void primeGeneratornegative10to10() {
		long from = -10;
		long to = 10;
		try {

			PrimeGenerator pgen = new PrimeGenerator(from, to);
			pgen.generatePrimes();
			Long[] expectedPrimes = {};
			assertArrayEquals(expectedPrimes, pgen.getPrimes().toArray());
		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=" + from + " to=" + to, ex.getMessage());
		}

	}

	@Test
	public void primeGenerator100to1() {
		long from = 100;
		long to = 1;
		try {

			PrimeGenerator pgen = new PrimeGenerator(from, to);
			pgen.generatePrimes();
			Long[] expectedPrimes = {};
			assertArrayEquals(expectedPrimes, pgen.getPrimes().toArray());
		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=" + from + " to=" + to, ex.getMessage());
		}

	}

}
