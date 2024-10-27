# java-racingcar-precourse
___

## 협력
___

### domain
___

> "경주할 자동차 이름"
- [ ] `class UserName`
  - [ ] `void checkMaximumLength()`
  - [ ] `void hasOnlyCharacters()`

> "전진"
- [ ] `class Score`
  - [ ] `void moveForward()`
  - [ ] `int getScore()`

> "몇 번의 이동을 할 것인지"
- [ ] `class RoundNumber`
  - [ ] `void checkMinimumValue()`

> "무작위 값을 구한 후"
- [ ] `interface NumberGenerator { int generateNumber() }`
- [ ] `class WoowaRandomNumberGenerator`
  - [ ] `int generateNumber()`

> "자동차"
- [ ] `class Car`
`Score score, UserName userName`
  - [ ] `int compareTo(Car o)`
  - [ ] `String getUserName()`
  - [ ] `int getScore()`

> 자동차들
- [ ] `class PlayersCars`
`List<Car> playersCars`
  - [ ] `void moveCar()`
  - [ ] `List<String> findMaximumScoreCars`

### io
___
- [ ] `interface UserInputHandler { String makeUserInputString, int makeUserInputInt }`
- [ ] `class WoowaUserInput`
  - [ ] `String makeUserInputString()`
  - [ ] `int makeUserInput()`

- [ ] `class ParserUserInput`
  - [ ] `void hasOnlyCharacters()`
  - [ ] `void split()`

- [ ] `class Printer`
  - [ ] `void printRoundResult()`
  - [ ] `void printFinalResult()`

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