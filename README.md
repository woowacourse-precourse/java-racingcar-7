# java-racingcar-precourse

# 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

---

# 기능 목록

## Controller

### Controller

- [x] 게임 실행하는 기능(gameStart)
- [x] 게임 진행 결과 출력하는 기능(printGame)

### InputController

- [x] 경주할 자동차 이름 입력하는 기능(inputCarNames)
- [x] 시도할 횟수 입력하는 기능(inputAttemptCount)

### OutputController

- [x] 개행 문자를 출력하는 기능(printEndLine)
- [x] "실행 결과" 메시지를 출력하는 기능(printGameResultMessage)
- [x] 레이스에 참가한 자동차들의 이름과 현 위치를 출력하는 기능(printRoundResult)
- [x] 우승자 출력하는 기능(printWinners)

### CarController

- [x] 입력한 문자열에서 이름 리스트를 가져 오는 기능(getName)
- [x] 입력받은 이름들로 차 등록하는 기능(registerCar)

### RaceController

- [x] 차 리스트와 시도 횟수로 레이스를 등록하는 기능(registerRace)
- [x] 게임을 한판 진행하는 기능(playRound)
- [x] 우승자 선정하는 기능(getWinnerCarList)
- [x] 레이스에 참가한 자동차 중 가장 멀리 이동한 값을 구하는 기능 (getMaxDistance)

## domain

### Car

- [x] 이름 가져 오는 기능(getName)
- [x] 위치 가져 오는 기능(getLocation)
- [x] 전진하는 기능(plussLocation)
- [x] 움직일 수 있는지 확인하는 기능(isMove) -[x] 랜덤 숫자를 뽑는 기능(pickNumber)

### Race

- [x] 레이스에 참가한 차들 리스트 가져오는 기능(getCarList)
- [x] 레이스를 시도할 횟수 반환받는 기능(getAttemptCount)
- [x] 레이스에 참가한 차들의 현재 위치를 리스트로 가져오는 기능(getDistanceList)

## service

### CarService

- [x] 각 이름을 ","로 구분하는 기능(splitCarNames)
- [x] 입력받은 이름들로 차 등록하는 기능(registerCar)

### RaceService

- [x] 차 리스트와 시도 횟수로 레이스를 등록하는 기능(registerRace)
- [x] 게임을 한판 진행하는 기능(playRound)
- [x] 레이스에 참가한 자동차 중 가장 멀리 이동한 값을 구하는 기능 (getMaxDistance)

## validate

### CarValidator

- [x] 차 이름의 길이는 5자 이내인지 확인하는 기능(carNameLengthLimit5)
- [x] 차 이름이 중복되었는지 확인하는 기능(noDuplicateCarNames)

### InputValidator

- [x] 입력한 문자열에서 자동차 이름을 뽑을때 검증하는 기능(validateInputCarNames)
- [x] 입력한 문자열에서 시도 횟수를 입력했을 때 검증하는 기능(validateInputAttemptCount)
- [x] 입력한 문열이 null인지 확인하는 기능(noNull)
- [x] 입력한 문자열이 빈 문자열, 공백인지 확인하는 기능(noBlank)
- [x] 입력한 문자열이 영어(소문자, 대문자)와 쉼표(",")로 이루어져 있는지 확인하는 기능(containsOnlyEnglishAndComma)
- [x] 입력한 문자열이 쉼표(",")로 시작하는지 확인하는 기능(noStartWithComma)
- [x] 입력한 문자열이 쉼표(",")로 끝나는지 확인하는 기능(noEndWithComma)
- [x] 쉼표(",")가 연속으로 입력되었는지 확인하는 기능(hasNoContinuousComma)
- [x] 시도 횟수는 (0~9)인 숫자인지 확인하는 기능(onlyInputNumber)

## view

### InputView

- [x] 경주할 자동차 이름을 입력받는 기능(getCarNames)
- [x] 시도 횟수를 입력받는 기능(getAttemptCount)

### OutputView

- [x] 개행 문자를 출력하는 기능(printEndLine)
- [x] "실행 결과" 메시지를 출력하는 기능(printGameResultMessage)
- [x] 레이스에 참가한 자동차들의 이름과 현 위치를 출력하는 기능(printRoundResult)
- [x] 우승자 출력하는 기능(printWinners)
- [x] 정수로 표현되는 현 위치를 "-"로 변환하는 기능(getDashString)
- [x] 우승자 문자열을 만드는 기능(createWinnersString)

---

# package 구조

```
racingcar
  ├── Application.java
  ├── config
  │   └── AppConfig.java
  ├── controller
  │   ├── CarController.java
  │   ├── Controller.java
  │   ├── InputController.java
  │   ├── OutputController.java
  │   └── RaceController.java
  ├── domain
  │   ├── Car.java
  │   └── Race.java
  ├── service
  │   ├── CarService.java
  │   └── RaceService.java
  ├── validate
  │   ├── CarValidator.java
  │   └── InputValidator.java
  └── view
      ├── InputView.java
      └── OutputView.java
```
