package boj.bronze.p2309_seven_dwarfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
		int[] A = new int[9];
		int i, j, sum = 0;

		// 아홉 난쟁이 키 입력받기
		for (i = 0; i < 9; i++) {
			A[i] = nextInt();
			sum += A[i];
		}

		// 일곱 난쟁이 키 리스트
		ArrayList<Integer> answer = new ArrayList<>();

		// 키 리스트에 담을 난쟁이 검사
		outer: for (i = 0; i < 8; i++) {
			for (j = i + 1; j < 9; j++) {
				int h_sum = sum - (A[i] + A[j]);

				// 일곱 난쟁이 키의 합이 100인지 검사
				if (h_sum == 100) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							answer.add(A[k]);
						}
					}
					// 정답 찾으면 이중 루프 완전 종료
					break outer;
				}
			}
		}

		// 키 리스트 오름차순 정렬
		Collections.sort(answer);

		// 키 리스트 출력
		StringBuilder sb = new StringBuilder();
		for (int k : answer) {
			sb.append(k).append('\n');
		}
		System.out.print(sb);
	}
}
