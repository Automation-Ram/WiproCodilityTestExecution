package com.codilityTest;

public class SumOfDigitsEquals {

	public static int sumOfDigits(int number) {
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println("Numbers whose sum of digits equals 10:");
		for (int i = 10; i <= 100; i++) {
			if (sumOfDigits(i) == 10) {
				System.out.println(i);
			}
		}
	}
}
