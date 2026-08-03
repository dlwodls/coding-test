package boj.silver.p2578_bingo;

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

	public static int checkBingo(boolean[][] board) {
		int bingo = 0; // 빙고 개수
		// 세로 빙고 확인
		for (int j = 0; j < board.length; j++) {
			int count = 0;
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] == true)
					count++;
			}
			if (count == 5)
				bingo++;
		}

		// 가로 빙고 확인
		for (int i = 0; i < board.length; i++) {
			int count = 0;
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == true)
					count++;
			}
			if (count == 5)
				bingo++;
		}

		// 대각선 빙고 확인
		int count = 0;

		// 왼쪽 대각선
		for (int i = 0; i < board.length; i++) {
			if (board[i][i] == true)
				count++;
		}
		if (count == 5)
			bingo++;

		// 오른쪽 대각선
		count = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][board.length - 1 - i] == true)
				count++;
		}
		if (count == 5)
			bingo++;

		return bingo;
	}

	public static void main(String[] args) throws IOException {
		int[][] board = new int[5][5]; // 빙고판
		boolean[][] bingo = new boolean[5][5]; // 빙고 유무
		int[] call = new int[25]; // 사회자가 부르는 수
		int result = 0; // 결과

		// 빙고판 입력
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = nextInt();
			}
		}

		// 사회자가 부르는 수 입력
		for (int i = 0; i < call.length; i++) {
			call[i] = nextInt();
		}

		// 빙고판에 체크
		for (int i = 0; i < call.length; i++) {

			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k < board[j].length; k++) {
					if (board[j][k] == call[i]) {
						bingo[j][k] = true;
					}
				}
			}
			int count = 0;
			count = checkBingo(bingo);

			if (count >= 3) {
				result = i + 1;
				break;
			}
		}

		System.out.println(result);
	}
}
