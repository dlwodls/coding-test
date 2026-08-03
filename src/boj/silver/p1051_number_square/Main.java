package boj.silver.p1051_number_square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] rect = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
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
