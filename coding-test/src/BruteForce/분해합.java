package BruteForce;

import java.util.Scanner;

public class 분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
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
