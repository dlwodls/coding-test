package BruteForce;

import java.util.Scanner;

public class 체스판_다시_칠하기 {
	public static int cnt(char[][] board, int x, int y) {
		int cnt_W = 0; // W로 시작할 때 다시 칠해야 하는 개수
		int cnt_B = 0; // B로 시작할 때 다시 칠해야 하는 개수

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char current = board[x + i][y + j];

				if ((i + j) % 2 == 0) {
					if (current != 'W')
						cnt_W++;
					if (current != 'B')
						cnt_B++;
				} else {
					if (current != 'B')
						cnt_W++;
					if (current != 'W')
						cnt_B++;
				}
			}
		}

		// cnt_B와 cnt_W 중에서 더 적은 cnt 수 return
		return Math.min(cnt_W, cnt_B);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.nextLine(); // 개행 처리

		char[][] board = new char[M][N];

		// 보드의 행 상태 입력
		for (int i = 0; i < M; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		// 시작점 찾기
		int min = 64;

		for (int i = 0; i < M - 7; i++) {
			for (int j = 0; j < N - 7; j++) {
				int cnt = cnt(board, i, j);
				if (min > cnt) {
					min = cnt;
				}
			}
		}

		System.out.println(min);
	}
}
