# java-racingcar-precourse

## 초간단 자동차 경주 게임

## 구현할 기능 목록

- [x] 테스트 작성
  - [x] 자동차 이름 구분 (5분)
  - [x] 랜덤 값에 따른 전진 여부 확인 (10분)
  - [x] 승자 판정 (15분)
  - [x] 잘못된 값 입력 시 예외 처리 (10분)
- [x] 기능 구현
  - [x] 자동차 이름 구분 (5분)
  - [x] 랜덤 값에 따른 전진 여부 확인 (5분)
  - [x] 승자 판정 (5분)
  - [x] 잘못된 값 입력 시 예외 처리 (35분)
  - [x] 입출력 적용 및 로직 연결 (35분)

최소 기능 제품(MVP) 완성까지 걸린 총 시간: 130분

## 처리할 예외 상황 목록

- 자동차 이름으로 "" 혹은 " "가 입력된 경우 `IllegalArgumentException`을 반환한다.
  - 구분자가 연속으로 입력된 경우도 자동차 이름이 공백으로 들어온 경우와 동일하게 처리한다.
- 자동차 이름이 5글자를 초과한 경우 `IllegalArgumentException`을 반환한다.
- 시도 횟수가 숫자가 아닌 경우 `IllegalArgumentException`을 반환한다.
- 시도 횟수가 음수인 경우 `IllegalArgumentException`을 반환한다.

## 실행 결과 예시

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