# java-racingcar-precourse

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.




- [X] Game Class
    - [X] variable : input, output
    - [X] method : playGame
        - [X] TestCode
- [X] Race Class
    - [X] variable : cars
    - [X] method : playOneRound, getWinnerCars, getCars
        - [X] TestCode
- [X] Input Class
    - [ ] variable : validator
    - [X] method : getCarnames, getTotalRound
        - [X] TestCode
- [X] Output Class
    - [X] method : viewOneRound, viewResult
        - [X] TestCode
- [X] Car Class
  - [X] variable : name, distance
  - [X] method : move, of(create Instance)
    - [X] TestCode
- [X] Validator Class
  - [X] method : validateMinCarCount, validateCarNameLength, tryParserToInt, validatePositiveNumber
    - [X] TestCode


## Game Class
Race, Input, Output 인스턴스를 이용해서 전체적인 코드 흐름에 대한 책임만을 가지고 있는 클래스이다.
Application에서 이 클래스만 가지고 호출하게 된다.

## Race Class
게임을 진행하는 코드 흐름에 대한 책임을 들고 있다. 그렇기에 게임에 참여하는 차와 게임에 대한 룰을 구현한 코드가 이 클래스에서 책임진다.

## Input Class
게임 이용자로부터 차 이름과 게임 라운드를 입력받는 책임을 들고 있다.

## Output Class
한 라운드가 끝날 때와 최종 결과를 출력하는 책임을 들고 있다.

### Car Class
차 객체를 만들기 위한 도메인 클래스이다. 여기에 객체 생성 및 내부 변수 관리를 담당한다.

### Validator Class
입력을 받을 때 필요한 검증을 담당하고 있는 클래스이다.