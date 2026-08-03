# coding-test

백준 / 프로그래머스 문제 풀이 기록. Java 21.

컨벤션은 [CONVENTION.md](./CONVENTION.md) 참고.

## 구조

| 경로 | 설명 |
|---|---|
| `src/boj/` | 백준. 티어별 분류 |
| `src/programmers/` | 프로그래머스. 레벨별 분류 |
| `src/template/` | 입출력 보일러플레이트 |
| `concept/` | 알고리즘 개념 정리 |
| `PROBLEM_TEMPLATE.md` | 문제별 회고 템플릿 |

## 풀이 목록

| 날짜 | 번호 | 제목 | 난이도 | 유형 | 경로 |
|---|---|---|---|---|---|
| 2025-08-04 | 2231 | [분해합](https://www.acmicpc.net/problem/2231) | Bronze II | 브루트포스 | [`p2231_decomposition_sum`](src/boj/bronze/p2231_decomposition_sum) |
| 2025-08-05 | 2309 | [일곱 난쟁이](https://www.acmicpc.net/problem/2309) | Bronze I | 브루트포스 | [`p2309_seven_dwarfs`](src/boj/bronze/p2309_seven_dwarfs) |
| 2025-08-06 | 10448 | [유레카 이론](https://www.acmicpc.net/problem/10448) | Bronze I | 브루트포스 | [`p10448_eureka_theory`](src/boj/bronze/p10448_eureka_theory) |
| 2025-08-07 | 14717 | [앉았다](https://www.acmicpc.net/problem/14717) | Bronze I | 브루트포스, 확률론 | [`p14717_sat_down`](src/boj/bronze/p14717_sat_down) |
| 2025-08-11 | 1018 | [체스판 다시 칠하기](https://www.acmicpc.net/problem/1018) | Silver IV | 브루트포스 | [`p1018_repaint_chessboard`](src/boj/silver/p1018_repaint_chessboard) |
| 2025-08-11 | 1051 | [숫자 정사각형](https://www.acmicpc.net/problem/1051) | Silver IV | 브루트포스 | [`p1051_number_square`](src/boj/silver/p1051_number_square) |
| 2025-08-11 | 1547 | [공](https://www.acmicpc.net/problem/1547) | Bronze II | 구현, 시뮬레이션 | [`p1547_ball`](src/boj/bronze/p1547_ball) |
| 2025-08-12 | 20546 | [기적의 매매법](https://www.acmicpc.net/problem/20546) | Silver V | 구현, 시뮬레이션 | [`p20546_miracle_trading`](src/boj/silver/p20546_miracle_trading) |
| 2025-08-13 | 2578 | [빙고](https://www.acmicpc.net/problem/2578) | Silver IV | 구현, 시뮬레이션 | [`p2578_bingo`](src/boj/silver/p2578_bingo) |
| 2025-08-14 | 14501 | [퇴사](https://www.acmicpc.net/problem/14501) | Silver III | DP, 브루트포스 | [`p14501_resignation`](src/boj/silver/p14501_resignation) |
| 2025-08-27 | 2748 | [피보나치 수 2](https://www.acmicpc.net/problem/2748) | Bronze II | DP | [`p2748_fibonacci_2`](src/boj/bronze/p2748_fibonacci_2) |

## 진행 상황

- 총 푼 문제: 11
- 백준: 11 (Bronze 6, Silver 5)
- 프로그래머스: 0

## 남은 정리

2025년 8월 Eclipse 프로젝트에서 마이그레이션한 문제들은 아래가 미완료 상태다.

- 전부 `Scanner` 사용 → `BufferedReader`로 교체 필요 (CONVENTION.md 6절)
- 문제별 README의 접근 / 복잡도 / 회고 미작성
- **난이도는 미검증 값.** solved.ac API가 막혀 자동 조회를 못 했다. 확인 후 수정할 것
