package boj.silver.p20546_miracle_trading;

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

	static int[] stock = new int[14];

	// BNP 방식
	public static int BNP(int balance) {
		int quantity = 0; // 보유 주식 수

		for (int i = 0; i < stock.length; i++) {
			if (balance >= stock[i]) {
				int buy = balance / stock[i]; // 오늘 살 수 있는 주식 수
				quantity += buy;
				balance -= buy * stock[i];
			}
		}

		return balance + quantity * stock[13];
	}

	// TIMIMG 방식
	public static int TIMING(int balance) {
		int quantity = 0; // 보유 주식 수
		int day_up = 0, day_down = 0;

		for (int i = 1; i < stock.length; i++) {
			if (stock[i] > stock[i - 1]) {
				day_up++;
				day_down = 0;
			} else if (stock[i] < stock[i - 1]) {
				day_down++;
				day_up = 0;
			} else {
				day_up = 0;
				day_down = 0;
			}

			// 3일 연속 하락
			if (day_down >= 3 && balance >= stock[i]) {
				int buy = balance / stock[i]; // 오늘 살 수 있는 주식 수
				quantity += buy;
				balance -= buy * stock[i];
			}

			// 3일 연속 상승
			if (day_up >= 3 && quantity > 0) {
				balance += quantity * stock[i];
				quantity = 0;
			}
		}

		return balance + quantity * stock[13];
	}

	public static void main(String[] args) throws IOException {
		int balance = nextInt();

		// 주가 입력
		for (int i = 0; i < stock.length; i++) {
			stock[i] = nextInt();
		}

		int bnp = BNP(balance);
		int timing = TIMING(balance);

		if (bnp > timing)
			System.out.println("BNP");
		else if (bnp < timing)
			System.out.println("TIMING");
		else
			System.out.println("SAMESAME");
	}
}
