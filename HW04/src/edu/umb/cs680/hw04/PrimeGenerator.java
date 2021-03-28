package edu.umb.cs680.hw04;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimeGenerator {
	protected long from, to;
	protected LinkedList<Long> primes = new LinkedList<Long>();

	public PrimeGenerator(long from, long to) {
		if (from >= 1 && to > from) {
			this.from = from;
			this.to = to;
		} else {
			throw new RuntimeException("incorrect input values: from=" + from + ", to=" + to);
		}
	}

	public LinkedList<Long> getPrimes() {
		return primes;
	};

	protected boolean isEven(long n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isPrime(long n) {
		// 1 or lower numbers are not considered as prime.
		if (n <= 1) {
			return false;
		}
		// Even numbers are not prime, except for 2 only.
		if (n > 2 && isEven(n)) {
			return false;
		}
		long i;
		// looping number "i" that can divide "n"
		for (i = (long) Math.sqrt(n); n % i != 0 && i >= 1; i--) {
		}
		// If such a number "i" is found, n is not prime. Otherwise, n is prime.
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void generatePrimes() {
		for (long n = from; n <= to; n++) {
			if (isPrime(n)) {
				primes.add(n);
			}
		}
	}

	public static void main(String[] args) {
		PrimeGenerator pgen = new PrimeGenerator(1, 100);
		pgen.generatePrimes();
		LinkedList<Long> primes = pgen.getPrimes();
		Iterator<Long> it = primes.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("\n" + pgen.getPrimes().size() + " primes are found.");
	}
}
