package BruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 일곱_난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] A = new int[9];
		int i, j, sum = 0;

		// 아홉 난쟁이 키 입력받기
		for (i = 0; i < 9; i++) {
			A[i] = sc.nextInt();
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
		for (int k : answer) {
			System.out.println(k);
		}
	}
}
