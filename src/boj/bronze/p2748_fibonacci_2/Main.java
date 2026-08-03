package boj.bronze.p2748_fibonacci_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
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
