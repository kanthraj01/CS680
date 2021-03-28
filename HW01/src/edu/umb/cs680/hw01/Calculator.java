package edu.umb.cs680.hw01;

public class Calculator {
	public float addition(float x, float y) {
		return x + y;
	}

	public float subtraction(float x, float y) {
		float z = x - y;
		if (z < 0) {
			throw new java.lang.IllegalArgumentException("X < Y");
		}
		return z;
	}

	public float multiply(float x, float y) {
		return x * y;
	}

	public float divide(float x, float y) {
		if (y == 0) {
			throw new IllegalArgumentException("Division By Zero");
		}
		return x / y;
	}

}
