package boj.silver.p14501_resignation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	// Scanner.nextInt() 처럼 줄바꿈에 상관없이 다음 토큰을 읽는다.
	private static int nextInt() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

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

	public static void main(String[] args) throws IOException {
		int N = nextInt();
		int[] T = new int[N];
		int[] P = new int[N];

		// 상담 기간, 금액 입력
		for (int i = 0; i < N; i++) {
			T[i] = nextInt();
			P[i] = nextInt();
		}

		int maxProfit = calculateProfit(N, T, P);

		System.out.println(maxProfit);
	}
}
