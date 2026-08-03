package template;

import java.io.*;
import java.util.*;

/**
 * 코딩테스트 입출력 템플릿.
 * 문제 폴더로 복사한 뒤 package 선언과 클래스명을 바꿔서 사용한다.
 */
public class FastIO {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 정수 한 개
        int n = Integer.parseInt(br.readLine().trim());

        // 한 줄에 공백으로 구분된 정수 여러 개
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N 줄에 걸쳐 정수 한 개씩
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            sb.append(x).append('\n');
        }

        // 출력은 StringBuilder 에 모았다가 한 번에
        System.out.print(sb);
    }
}
