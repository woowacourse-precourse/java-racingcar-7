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