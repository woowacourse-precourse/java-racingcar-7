# java-racingcar-precourse

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

**입력**

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 횟수

```
5
```

**출력**

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

**실행 결과 예시**

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
최종 우승자 : pobi, jun
```

---

## 고려할 사항

- 자동차 이름 사이에 공백을 허용한다.
- 자동차 이름은 중복을 허용하지 않는다.
- 입력이 `,,`와 같이 자동차 이름이 아예 없을 경우 예외를 발생시킨다.

---

## 기능 목록

### 1. Input

입력에 관한 클래스

`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하여 입력 구현

**getCarNames()**
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

**getAttemptCount()**
- 시도할 횟수

### 2. Output

출력에 관한 클래스

**printResult()**
- 매회 실행 결과 출력 함수

**printWinner()**
- 우승자 출력 함수

### 3. Message

message를 상수(enum)로 관리하는 클래스

### 4. CarValidator

자동차 유효성 검증 클래스

**validateCarName()**
- 자동차의 이름 형식이 올바른지 확인하는 함수

**checkDuplicateCarName()**
- 자동차의 이름이 중복됐는지 확인하는 함수

### 5. RacingCarService

자동차 서비스에 관한 클래스

**saveCars()**
- 자동차 목록을 저장하는 함수

**saveResult()**
- 자동차의 실행 결과를 저장하는 함수

**extractRandom()**
- `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 Random 값 추출

### 6. RacingCarController

자동차 메인 로직에 관한 클래스

**run()**
- 자동차 경주를 실행하는 함수

**start()**
- 자동차 경주를 시작하는 함수

**progress()**
- 자동차 경주를 진행하는 함수

**end()**
- 자동차 경주를 종료하는 함수



