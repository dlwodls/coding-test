package boj.bronze.p1547_ball;

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

	public static void main(String[] args) throws IOException {
		int M = nextInt(); // 컵의 위치를 바꾼 횟수

		int[] cup = new int[3];

		for (int i = 0; i < cup.length; i++) {
			cup[i] = i + 1;
		}

		for (int i = 0; i < M; i++) {
			// 컵의 위치를 바꾼 방법 X, Y
			int X = nextInt();
			int Y = nextInt();

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
