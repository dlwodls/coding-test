package DP;

import java.util.Scanner;

public class 피보나치_수_2 {
	static long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		dp = new long[n + 1];

		System.out.println(fibo(n));
	}

	static long fibo(int x) {
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < x + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[x];
	}
}
