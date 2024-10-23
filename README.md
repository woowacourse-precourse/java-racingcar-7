# java-racingcar-precourse
## 자동차 경주


# 흐름
1. 경주할 자동차 이름 입력받기
2. 시도할 횟수 입력 받기
3. 잘못된 입력은 예외 처리
4. 객체 생성
5. (만들어진 객체를 가지고) 게임 시작
6. 각각 랜덤값 생성
7. 전진 조건 검사
8. 반영하여 출력
9. 횟수가 다 됐다면 (게임 종료) 우승자 출력

# 기능 목록

| 기능 ID | 기능 이름 | 기능 설명 | 관련 함수 | 테스트 함수 |
| --- | --- | --- | --- | --- |
| 1 | 자동차 이름 처리 | 경주할 자동차의 이름을 처리함 | convertCarNames() | convertCarNamesTest() |
| 2 | 시도 횟수 입력 처리 | 게임을 진행할 횟수를 처리함 | convertAttempts() | convertAttemptsTest() |
| 3 | 입력 유효성 검사 | 잘못된 입력에 대한 예외 처리 | validateInput() | validateInputTest() |
| 4 | 자동차 객체 생성 | 입력받은 이름으로 자동차 객체 생성 | createCarObjects() | createCarObjectsTest() |
| 5 | 게임 실행 | 생성된 객체로 게임 진행 | startRace() | StartRaceTest() |
| 6 | 랜덤값 생성 | 각 자동차의 이동을 위한 랜덤값 생성 | generateRandomValue() | generateRandomValueTest() |
| 7 | 전진 조건 검사 | 랜덤값에 따른 전진 여부 결정 | checkMoveCondition() | checkMoveConditionTest() |
| 8 | 게임 상태 출력 | 각 라운드마다 자동차들의 위치 출력 | printGameStatus() | printGameStatusTest() |
| 9 | 우승자 선정 | 게임 종료 후 우승자 결정 및 출력 | determineWinner() | determineWinnerTest() |

---

# 미션 정리

## 기능 요구 사항
- 주어진 횟수동안 n대의 자동차가 전/후진
- 전진하는 자동차 출력 시 자동차 이름도 함께 출력
- 자동차 이름은 쉼표로 구분하여 5자 이하
- 사용자가 이동횟수 입력
- 전진 조건 : 0-9사이 랜덤 값 중 4이상
- 경주 게임 완료 후 우승자 출력(한 명 이상)
- 여러 명일 경우 쉼표로 구분
- 잘못된 값 입력 시 `IllegalArgumentException`


## 입출력 요구 사항
### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```shell
pobi,woni,jun
```
시도할 횟수
```shell
5
```
### 출력
- 차수별 실행 결과
```shell
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```shell
최종 우승자 : pobi
```

- 공동 우승자 안내 문구
```shell
최종 우승자 : pobi, jun
```

### 실행 결과 예시
```shell
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