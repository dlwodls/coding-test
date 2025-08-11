package BruteForce;

import java.util.Scanner;

public class 숫자_정사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();

		char[][] rect = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				rect[i][j] = line.charAt(j);
			}
		}

		int max = 1;

		// 시작점 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 변의 길이의 범위
				for (int k = 1; i + k < N && j + k < M; k++) {
					if (rect[i][j] == rect[i][j + k] && rect[i][j] == rect[i + k][j]
							&& rect[i][j] == rect[i + k][j + k]) {
						int area = (k + 1) * (k + 1);
						if (area > max) {
							max = area;
						}
					}
				}
			}
		}

		System.out.println(max);
	}
}
