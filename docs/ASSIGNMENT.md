# 자동차 경주 게임

## 과제 진행 요구사항

- 미션은 자동차 경주 저장소 포크 및 클론으로 시작
- `README.md`에 구현할 기능 목록을 먼저 정리
- Git 커밋은 기능 목록 단위로 추가
    - AngularJS Git Commit Message Conventions 참고하여 작성
- 상세 진행 방법은 프리코스 가이드 문서 참고

## 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- N대의 자동차가 주어진 횟수만큼 전진 또는 멈춤
- 각 자동차에 이름 부여 가능 (출력 시 이름 포함)
- 자동차 이름은 쉼표(,)로 구분, 5자 이하만 가능
- 이동 횟수는 사용자 입력
- 전진 조건: 무작위 값(0-9)이 4 이상일 경우
- 게임 완료 후 우승자 안내 (복수 우승 가능)
- 복수 우승자는 쉼표(,)로 구분
- 잘못된 입력 시 `IllegalArgumentException` 발생 후 종료

## 입출력 요구사항

### 입력

```
경주할 자동차 이름: pobi,woni,jun
시도할 횟수: 5

```

### 출력

- 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---

```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi

```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun

```

-실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 프로그래밍 요구사항

### 기본 요구사항

- JDK 21 사용
- 시작점: `Application.main()`
- `build.gradle` 변경 불가
- 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 금지
- `System.exit()` 호출 금지
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동 금지
- 자바 코드 컨벤션 준수 (Java Style Guide)

### 코드 구현 요구사항

- indent depth ≤ 2
- 3항 연산자 사용 금지
- 함수는 단일 책임 원칙 준수
- JUnit 5, AssertJ로 테스트 코드 작성

### 사용 라이브러리

- `camp.nextstep.edu.missionutils` 패키지의 API 사용
    - `Randoms.pickNumberInRange()`: 랜덤값 추출
    - `Console.readLine()`: 사용자 입력

예시:

```
// 0-9 사이의 랜덤 정수 반환
Randoms.pickNumberInRange(0, 9);

```

---

[🔝 맨 위로 돌아가기](#자동차-경주-게임)