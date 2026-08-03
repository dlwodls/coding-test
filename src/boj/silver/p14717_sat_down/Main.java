package boj.silver.p14717_sat_down;

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

	// 상대가 이기는 경우 세는 함수
	public static int cnt_case(int a, int b) {
		int cnt = 0;
		int add = (a + b) % 10;

		for (int i = 1; i <= 10; i++) {
			for (int j = i; j <= 10; j++) {
				// 내가 이미 사용한 카드는 상대가 뽑으면 안 됨
				if ((i == a && j == b) || (i == b && j == a))
					continue;

				if (i == j) {
					cnt++;
				} else {
					if (add < ((i + j) % 10))
						cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		int A = nextInt();
		int B = nextInt();

		double possibility = 0;

		// 내가 땡일 경우, 상대가 나보다 위의 땡인 경우만 세면 됨
		if (A == B) {
			possibility = (double) (153 - (10 - A)) / 153;
		}
		// 내가 끗일 경우, 상대가 땡이거나, 위의 끗인 경우 세면 됨
		else {
			possibility = (double) (cnt_case(A, B)) / 153;
		}

		System.out.printf("%.3f", possibility);
	}
}
