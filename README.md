# java-racingcar-precourse
___

## 협력
___

### domain
___

> "경주할 자동차 이름"

- [x] `class UserName`
    - [x] `void checkMaximumLength(String userName)`
    - [x] `void hasOnlyCharacters(String userName)`

> "전진"

- [x] `class Score`
    - [x] `void moveForward()`
    - [x] `int getScoreValue()`

> "몇 번의 이동을 할 것인지"

- [x] `class RoundNumber`
    - [x] `void checkMinimumValue()`
    - [x] `int getRoundNumber()`

> "무작위 값을 구한 후"

- [x] `interface NumberGenerator { int generateNumber() }`
- [x] `class WoowaRandomNumberGenerator`
    - [x] `int generateNumber()`

> "자동차"

- [x] `class Car`
  `Score score, UserName userName`
    - [x] `int compareTo(Car o)`
    - [x] `String getUserName()`
    - [x] `Score getScore()`
    - [x] `void moveCar(int randomNumber)`

> 자동차들

- [x] `class PlayersCars`
  `List<Car> playersCars`
    - [x] `void moveSequence(NumberGenerator numberGenerator)`
    - [x] `List<String> findMaximumScoreCars()`
    - [x] `List<Car> getPlayersCars()`

### io
___

- [x] `interface UserInputHandler { String makeUserInputString, int makeUserInputInt }`
- [x] `class WoowaUserInput`
    - [x] `String makeUserInputString()`
    - [x] `int makeUserInput()`

- [x] `class ParserUserInput`
    - [x] `void split(String parseTarget)`

- [x] `class Printer`
    - [x] `void printRoundResult(List<Car> roundResult)`
    - [x] `void printFinalResult(List<String> finalResult)`

### controller
___

- [x] `class Controller`
    - [x] `void run()`