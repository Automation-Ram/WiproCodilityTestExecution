package com.codilityTest;

public class FindNextNumber {

	public static int digitSum(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static int findNextNumber(int n) {
		int originalSum = digitSum(n);
		int currentNumber = n + 1;

		while (true) {

			int currentSum = digitSum(currentNumber);

			if (currentSum == originalSum) {
				return currentNumber;
			}

			currentNumber++;
		}
	}

	public static void main(String[] args) {
		int N = 1990;
		int nextNumber = findNextNumber(N);
		System.out.println(
				"The next number after " + N + " with the same digit sum and no integer in between is: " + nextNumber);
	}
}
