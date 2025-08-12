package Simulation;

import java.util.Scanner;

public class 기적의_매매법 {
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int balance = sc.nextInt();

		// 주가 입력
		for (int i = 0; i < stock.length; i++) {
			stock[i] = sc.nextInt();
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
