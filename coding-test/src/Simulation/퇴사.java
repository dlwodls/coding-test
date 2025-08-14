package Simulation;

import java.util.Scanner;

public class 퇴사 {
	public static int calculateProfit(int N, int T[], int P[]) {
		int maxProfit = 0;

		// 모든 날
		for (int i = 0; i < N; i++) {
			int day = i;
			int profit = 0;

			while (day < N) {
				// 퇴사 전
				if (day + T[day] <= N) {
					profit += P[day];
					day += T[day];
				} else
					break;
			}

			maxProfit = Math.max(maxProfit, profit);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] T = new int[N];
		int[] P = new int[N];

		// 상담 기간, 금액 입력
		for (int i = 0; i < N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		int maxProfit = calculateProfit(N, T, P);

		System.out.println(maxProfit);
	}
}
