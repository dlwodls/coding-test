package Simulation;

import java.util.Scanner;

public class 공 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 컵의 위치를 바꾼 횟수

		int[] cup = new int[3];

		for (int i = 0; i < cup.length; i++) {
			cup[i] = i + 1;
		}

		for (int i = 0; i < M; i++) {
			// 컵의 위치를 바꾼 방법 X, Y
			int X = sc.nextInt();
			int Y = sc.nextInt();

			int tmp;
			outer: for (int j = 0; j < cup.length; j++) {
				for (int k = 0; k < cup.length; k++) {
					if (cup[j] == X && cup[k] == Y) {
						tmp = cup[j];
						cup[j] = cup[k];
						cup[k] = tmp;

						break outer;
					}
				}
			}
		}

		System.out.println(cup[0]);
	}
}
