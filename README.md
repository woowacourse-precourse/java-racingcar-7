# java-racingcar-precourse

##기능 구현목록


# Car 클래스

Car 클래스는 자동차의 위치와 이름을 관리하고 특정 조건에 따라 전진하는 기능을 제공한다.

## 변수

###Position
-현재 자동차의 위치를 나타내는 정수 변수이다. 초기값은 `0`으로 설정된다.

###carName
-자동차의 이름을 나타내는 문자열 변수이다. 쉼표(`,`)로 자동차의 이름을 구분하고 이름은 최대 5자까지만 가능하다.

## 메서드

### getCarName()

- 자동차의 이름(carName)을 반환한다.
- 반환값: String - 자동차의 이름

### getPosition()

- 설명: 현재 자동차의 위치를 반환한다.
- 반환값: int - 현재 위치 값

### moveForward()

-  자동차를 전진시키는 메서드이다.  
   (전진 조건은 0에서 9 사이의 무작위 값을 생성하고, 그 값이 `4` 이상일 때 자동차가 전진한다.)
- 전진 성공 시: Position 값이 1씩 증가한다.
- 전진 실패 시: Position 값은 변경되지 않는다.




# RacingGame 클래스

RacingGame 클래스는 Car 클래스를 포함한다.
자동차 이름과 라운드 수를 입력받는 매서드,경주를 진행하는 매서드, 그리고 최종 우승자를 출력하는 매서드를 가진 클래스이다.
camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.

## 변수

- cars: Car 객체를 저장하는 리스트이다.
- rounds: 게임의 라운드 수를 저장하는 정수 변수이다.

## 메서드

### inputCars()

- Console.readLine()을 사용하여 입력을 받는다.
  -입력받은 문자열을 쉼표로 분리하여 각 이름을 추출한다. 그리고 그 이름으로 Car 객체를 생성하여 cars 링크드리스트에 추가한다.
  -이름은 1~5 글자까지만 허용되며 조건에 맞지 않을 경우 IllegalArgumentException을 발생시킨다.

### inputRound()

-Console.readLine()을 사용하여 입력을 받는다. 그 후 정수로 변환하여 round 변수에 저장한다.
-입력값이 0 이하인 경우와 숫자가 아닌경우 IllegalArgumentException을 발생시킨다.

### runGame()

-각 라운드마다 모든 자동차가 Randoms.pickNumberInRange(0, 9)를 호출하여 0에서 9 사이의 무작위 값을 생성한다.
-생성된 값을 Car클래스의 moveForward() 메서드로 넘긴다음 4 이상일 때만 자동차가 전진한다.
-각 라운드 종료 시 printRoundStatus() 메서드를 호출하여 현재 상태를 출력한다.

### printRoundStatus()

- cars 링크드리스트에 있는 각 car 객체들을 꺼내와서 이름과 위치를 나타내는 - 문자를 이용해 경주 진행 상태를 표시한다.

### printWinners()
-자동차의 위치 값을 저장할 리스트 positions를 생성하고 각 Car객체의 getposition()을 이용하여 위치값을 리스트 positions에 넣는다.
-최대 위치를 찾기 위한 int maxPosition을 생성하고 0으로 설정한다. 그리고 positions 리스트에서 최대 위치값을 찾아 maxPosition에 할당한다.
-우승자 목록을 저장할 리스트 winners를 생성하고 각 Car객체 position값과 maxPosition값이 일치하는 객체를 찾아 리스트 winners에 할당한다.
