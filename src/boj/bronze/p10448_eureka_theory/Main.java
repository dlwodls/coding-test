package boj.bronze.p10448_eureka_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

	public static int T(int n) {
		ArrayList<Integer> tri = new ArrayList<>();
		// 삼각수 리스트에 미리 저장
		for (int i = 1;; i++) {
			int t = i * (i + 1) / 2;
			if (t > 1000)
				break;
			tri.add(t);
		}

		for (int i = 0; i < tri.size(); i++) {
			for (int j = 0; j < tri.size(); j++) {
				for (int k = 0; k < tri.size(); k++) {
					if (tri.get(i) + tri.get(j) + tri.get(k) == n) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		int N = nextInt(); // 테스트케이스의 개수
		int[] A = new int[N]; // 테스트케이스 예시 저장할 배열

		// 테스트 케이스 N개 입력
		for (int i = 0; i < N; i++) {
			A[i] = nextInt();
		}

		// 결과값 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(T(A[i])).append('\n');
		}
		System.out.print(sb);
	}
}
