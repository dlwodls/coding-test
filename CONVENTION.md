# 코딩테스트 리포지토리 컨벤션

## 1. 디렉터리 구조

```
coding-test/
├── README.md              # 푼 문제 목록
├── CONVENTION.md          # 이 파일
├── PROBLEM_TEMPLATE.md    # 문제별 회고 템플릿 (복사해서 사용)
├── .gitignore
├── concept/               # 알고리즘 개념 정리 (Java 아님, 소스 루트 밖)
│   ├── dp.md
│   ├── bfs-dfs.md
│   └── dijkstra.md
└── src/                   # ← IntelliJ 소스 루트
    ├── boj/               # 백준
    │   ├── bronze/
    │   ├── silver/
    │   │   └── p1927_min_heap/
    │   │       ├── Main.java
    │   │       └── README.md
    │   ├── gold/
    │   └── platinum/
    ├── programmers/       # 프로그래머스
    │   ├── lv1/
    │   ├── lv2/
    │   │   └── p42586_progress_check/
    │   │       ├── Solution.java
    │   │       └── README.md
    │   └── lv3/
    └── template/
        └── FastIO.java
```

### 왜 `src/` 아래인가

IntelliJ는 **소스 루트로 지정된 디렉터리 안에 있는 `.java` 파일에만** 자동완성, 실행 버튼, 디버거를 붙인다.
`src/` 밖에 두면 코드가 회색으로 죽고 실행이 안 된다. 그래서 문제 풀이는 전부 `src/` 아래에 둔다.

`concept/`은 마크다운뿐이라 소스 루트 밖에 둔다.

### 분류 기준

**플랫폼 → 난이도 → 문제.**
알고리즘 유형별(DP, BFS…) 묶음은 폴더로 만들지 않고 `concept/*.md`에서 문제 폴더로 링크한다.
한 문제가 여러 유형에 걸치는 경우가 많아서, 폴더를 유형으로 나누면 중복이 생긴다.

## 2. 네이밍 규칙

`src/` 아래 모든 디렉터리는 **Java 패키지명이 된다.** 따라서 Java 식별자 규칙을 따라야 한다.

| 대상 | 규칙 | 예 |
|---|---|---|
| 리포명 | 소문자 + 하이픈 | `coding-test` |
| 문제 폴더 | `p{번호}_{영문_스네이크}` | `p1927_min_heap` |
| 패키지 선언 | 경로 그대로 | `package boj.silver.p1927_min_heap;` |
| 클래스/파일 | 백준 `Main.java`, 프로그래머스 `Solution.java` | 제출 형식에 맞춤 |
| 개념 문서 | 소문자 + 하이픈 + `.md` | `bfs-dfs.md` |
| 브랜치 | `main` 단일 | 코테 리포는 브랜치 안 씀 |

### 문제 폴더에 `p` 접두사를 붙이는 이유

Java 식별자는 숫자로 시작할 수 없다. 폴더명이 `1927`이면 `package boj.silver.1927;`이 되어 컴파일 에러다.
`p1927`로 쓴다.

### 하이픈 대신 언더스코어

Java 식별자에 `-`가 들어갈 수 없다. `min-heap`은 패키지명이 될 수 없으므로 `min_heap`.
(리포명 `coding-test`는 패키지가 아니므로 하이픈 그대로 둔다.)

### 금지 사항

- **한글 폴더/파일명 금지.** macOS는 파일명을 NFD(자음·모음 분리)로, Linux·Windows는 NFC로 저장한다.
  같은 `힙`이 OS마다 다른 바이트열이 되어 git이 서로 다른 파일로 인식하고, CI를 붙이면 깨진다.
  Java 패키지명으로도 부적절하다.
- **특수문자·공백 금지.** `+ ＋ # ? : * " < > |` 전부 안 됨.
  백준 1000번 `A+B`는 `p1000_a_plus_b`.
- **대문자 금지(패키지).** macOS 기본 파일시스템(APFS)은 대소문자를 구분하지 않아
  `MinHeap`과 `minheap`을 같은 폴더로 보지만, Linux는 다른 폴더로 본다. 클래스명만 대문자로 시작한다.

## 3. 새 문제 푸는 절차

1. `src/boj/{티어}/p{번호}_{슬러그}/` 폴더 생성
2. `Main.java` 생성 → 첫 줄에 `package boj.{티어}.p{번호}_{슬러그};`
   (IntelliJ가 파일 만들 때 패키지 선언을 자동으로 넣어준다)
3. `src/template/FastIO.java` 내용 복사해서 시작
4. 풀고 나서 같은 폴더에 `README.md` 작성 — `PROBLEM_TEMPLATE.md` 복사
5. 루트 `README.md` 표에 한 줄 추가
6. 커밋

## 4. 문제별 README

각 문제 폴더에 `README.md`를 둔다. **이게 이 리포의 핵심이다.**
정답 코드만 쌓으면 복습이 안 된다. 틀린 이유를 적어야 같은 실수를 반복하지 않는다.

빈 템플릿은 루트 `PROBLEM_TEMPLATE.md`. 작성 예시:

```markdown
# [BOJ 1927] 최소 힙

- 링크: https://www.acmicpc.net/problem/1927
- 난이도: Silver II
- 유형: 자료구조, 우선순위 큐
- 소요 시간: 25분
- 결과: 1차 시도 시간 초과 → 2차 정답

## 접근

우선순위 큐로 최솟값을 O(log N)에 꺼낸다.
배열을 매번 정렬하면 연산마다 O(N log N)이라 N=100,000에서 터진다.

## 복잡도

- 시간: O(N log N)
- 공간: O(N)

## 막힌 부분 / 틀린 이유

`Scanner`로 입력받아서 시간 초과. `BufferedReader`로 교체.
백준에서 입력이 10만 줄 넘어가면 `Scanner`는 무조건 터진다고 보면 된다.

## 배운 것

`PriorityQueue`는 기본이 최소 힙.
최대 힙은 `new PriorityQueue<>(Collections.reverseOrder())`.
```

## 5. 커밋 컨벤션

```
solve: [BOJ 1927] 최소 힙
solve: [PGS lv2] 기능개발
fix: [BOJ 1927] 시간 초과 개선
docs: 다익스트라 개념 정리
chore: gitignore 수정
```

- 타입: `solve` / `fix` / `docs` / `chore`
- 제목 50자 이내, 마침표 없음
- 본문은 문제 README에 이미 있으니 생략
- **문제 1개 = 커밋 1개.** 여러 문제를 한 번에 커밋하지 않는다 (잔디와 히스토리가 뭉개짐)

## 6. Java 코드 규칙

### 실행 환경

- 로컬 JDK: **Eclipse Temurin 21 (LTS)**
- 채점 서버는 대개 로컬보다 낮은 버전이다. 제출 전 해당 플랫폼의 지원 Java 버전을 확인하고,
  최신 문법(레코드 패턴, 신규 컬렉션 API 등)은 피한다.

### 입출력 — 백준에만 해당

**프로그래머스는 표준 입력을 쓰지 않는다.** 입력이 `solution()` 메서드의 인자로 들어오므로
`Scanner`도 `BufferedReader`도 등장하지 않는다. 아래 규칙은 백준 전용이다.

```java
// 프로그래머스: 입력은 인자로 온다
public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // ...
    }
}
```

#### 백준: `Scanner` 금지, `BufferedReader` 사용

`Scanner`는 `nextInt()` 한 번마다 정규식으로 토큰 경계를 찾고 정수인지 다시 검증한다.
버퍼도 1024자로 작아 시스템 콜이 잦다. `BufferedReader`는 8192자 버퍼에서 줄만 넘겨주고
파싱은 `Integer.parseInt` / `StringTokenizer`에 맡긴다.

정수 100만 개 입력 기준 (JDK 21, Apple Silicon 실측):

| 방식 | 소요 |
|---|---|
| `Scanner` | 약 250 ms |
| `BufferedReader` | 약 35 ms |

**약 7배.** 백준 시간 제한은 보통 1~2초라, 입력에만 250ms를 쓰면 알고리즘 예산이 그만큼 준다.
알고리즘이 맞는데도 시간 초과가 나는 원인이 대부분 여기다. 그러면 엉뚱한 데서 원인을 찾게 된다.

입력이 작은 문제에서는 차이가 없지만, 그때그때 판단하지 말고 **항상** `BufferedReader`로 시작한다.

템플릿은 `src/template/FastIO.java`.

```java
package boj.silver.p1927_min_heap;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // ...

        System.out.print(sb);
    }
}
```

- 출력이 여러 줄이면 `System.out.println`을 반복 호출하지 말고 `StringBuilder`에 모았다가 한 번에 출력한다.
  `println`은 호출마다 flush가 일어나 10만 줄이면 그것만으로 시간 초과가 난다.
- 공백 단위 파싱은 `split(" ")`보다 `StringTokenizer`가 빠르다.

### 제출할 때

**`package` 선언은 지우고 제출한다.** 백준·프로그래머스 채점기는 기본 패키지를 기대한다.
클래스명도 플랫폼 요구에 맞춘다 (백준은 `Main`, 프로그래머스는 `Solution`).

로컬에서는 패키지를 유지해야 IntelliJ가 문제별 폴더를 구분한다. 이 둘은 어쩔 수 없이 다르다.

## 7. .gitignore

IntelliJ 프로젝트 설정(`.idea/`, `*.iml`)과 컴파일 산출물(`*.class`, `out/`)은 커밋하지 않는다.
`.idea/`는 로컬 절대경로와 JDK 경로가 박혀 있어서 다른 환경에서 열면 깨지고, 열 때마다 diff가 발생한다.
