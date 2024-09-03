package com.codilityTest;

public class sumOfDigits {

	public static int sumOfDigits(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	public static int findM(int N) {
		int sumN = sumOfDigits(N);
		int M = N + 1;

		while (true) {
			int sumM = sumOfDigits(M);

			if (sumM == sumN) {
				boolean validM = true;

				for (int i = N + 1; i < M; i++) {
					if (sumOfDigits(i) == sumN) {
						validM = false;
						break;
					}
				}

				if (validM) {
					return M;
				}
			}

			M++;
		}
	}

	public static void main(String[] args) {
		int N = 1000;
		int result = findM(N);
		System.out.println("For N = " + N + ", the smallest M is: " + result);
	}
}
