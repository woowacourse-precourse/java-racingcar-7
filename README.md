# java-racingcar-precourse
___

## 협력
___

### domain
___

> "경주할 자동차 이름"

- [x] `class UserName`
    - [x] `void checkMaximumLength()`
    - [x] `void hasOnlyCharacters()`

> "전진"

- [x] `class Score`
    - [x] `void moveForward()`
    - [x] `int getScore()`

> "몇 번의 이동을 할 것인지"

- [x] `class RoundNumber`
    - [x] `void checkMinimumValue()`

> "무작위 값을 구한 후"

- [x] `interface NumberGenerator { int generateNumber() }`
- [x] `class WoowaRandomNumberGenerator`
    - [x] `int generateNumber()`

> "자동차"

- [x] `class Car`
  `Score score, UserName userName`
    - [x] `int compareTo(Car o)`
    - [x] `String getUserName()`
    - [x] `int getScore()`

> 자동차들

- [x] `class PlayersCars`
  `List<Car> playersCars`
    - [x] `void moveCar()`
    - [x] `List<String> findMaximumScoreCars`

### io
___

- [x] `interface UserInputHandler { String makeUserInputString, int makeUserInputInt }`
- [x] `class WoowaUserInput`
    - [x] `String makeUserInputString()`
    - [x] `int makeUserInput()`

- [x] `class ParserUserInput`
    - [x] `void hasOnlyCharacters()`
    - [x] `void split()`

- [x] `class Printer`
    - [x] `void printRoundResult()`
    - [x] `void printFinalResult()`

### controller
___

- [ ] `class Controller`
    - [ ] `void run()`
        - [ ] `void playRound(RoundNumber)`
            - [ ] `void playersCars.moveCar`
            - [ ] `void printRoundResult()`
        - [ ] `void printFinalResult()`

## 구현

___