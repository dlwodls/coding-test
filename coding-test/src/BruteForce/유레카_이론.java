package BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class 유레카_이론 {
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 테스트케이스의 개수
		int[] A = new int[N]; // 테스트케이스 예시 저장할 배열

		// 테스트 케이스 N개 입력
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		// 결과값 출력
		for (int i = 0; i < N; i++) {
			System.out.println(T(A[i]));
		}
	}
}
