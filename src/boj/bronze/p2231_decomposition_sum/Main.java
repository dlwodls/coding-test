package boj.bronze.p2231_decomposition_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int result = 0;
		// N의 자릿수
		int len = String.valueOf(N).length();
		// 최소 생성자
		int minNum = N - len * 9;

		if (minNum < 1)
			minNum = 1;

		for (int i = minNum; i < N; i++) {
			int sum = i;
			int tmp = i;
			while (tmp > 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			if (sum == N) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}
}
