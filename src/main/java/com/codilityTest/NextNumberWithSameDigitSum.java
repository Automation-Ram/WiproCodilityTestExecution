package com.codilityTest;

public class NextNumberWithSameDigitSum {

	public static int sumOfDigits(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static int nextNumberWithSameDigitSum(int N) {

		int originalSum = sumOfDigits(N);

		int nextNumber = N + 1;
		while (sumOfDigits(nextNumber) != originalSum) {
			nextNumber++;
		}

		return nextNumber;
	}

	public static void main(String[] args) {
		int N = 734;

		int result = nextNumberWithSameDigitSum(N);
		System.out.println("The next number with the same digit sum as " + N + " is: " + result);
	}
}
