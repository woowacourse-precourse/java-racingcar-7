# java-racingcar-precourse

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 횟수

```
5
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

### 실행 결과 예시

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


## 주의해야할 프로그래밍 요구사항
- JUnit 5와 AssertJ를 이용할 것
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 3항 연산자를 쓰지 않는다.
- **camp.nextstep.edu.missionutils**에서 제공하는 **Randoms** 및 **Console API**를 사용하여 구현해야 한다.
- Random 값 추출은 **camp.nextstep.edu.missionutils.Randoms**의 **pickNumberInRange**를 활용한다.
- 사용자가 입력하는 값은 **camp.nextstep.edu.missionutils.Console**의 **readLine**을 활용한다.


## 구현할 기능 목록
- 입력
- 자동차 등록
    - 자동차 이름 입력
    - 자동차 이름 구분
        - 자동차 이름 검증
    - 실행할 횟수 입력
        - 입력한 횟수 검증
- 자동차 경주 결과
    - 무작위 값 구하기
    - 턴 당 이동
        - 턴 당 실행 결과 출력
- 결과 계산
- 결과 출력


## 파일 구조
- controller
- view
- model
- util
- service
- exception


## 메소드 시그니처
- view
  - input() -> String
  - carRegistMessage() -> void
  - newLine() -> void
  - countRegistMessage() -> void
  - executionMessage() -> void
  - printResult(List<Car>) -> void
  - finalWinnerMessage(List<Var>) -> void
- controller
  - carRegist() -> List<Car>
  - registExecutionNumber() -> Long
  - race(List<Car>, ExecutionNumber) -> List<Car>
  - raceResult(List<Car>) -> void
- service
  - splitInput(String) -> List<String>
  - convertToCar(List<String>) -> List<Car>
  - parseToLong(String) -> Long
  - isMoving() -> boolean
  - randomNumber() -> int
  - raceResult(List<Car>) -> List<Car>
  - isRaceStarted(Integer) -> boolean
  - isValidLength(List<String>) -> boolean
  - isNumber(String) -> boolean
  - containsInvalidCharacter(String) -> boolean
  - isValidRange(String) -> boolean


## 예외 목록
- 빈 입력값 예외
- 특수문자 입력 예외
- 입력값 길이 예외
- 시도 횟수 입력 시 문자 예외
- 숫자 범위 예외
- 모든 자동차 시작 위치 예외