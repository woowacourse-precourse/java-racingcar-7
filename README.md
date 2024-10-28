# java-racingcar-precourse

## 기능 요구사항
- [x] 사용자로부터 문자열을 입력받아 게임 진행에 필요한 정보를 저장한다 
  - [x] 사용자 입력 메시지를 출력한다 
  - [x] 자동차 이름을 문자열로 입력받는다
  - [x] 사용자로부터 몇 번 이동할 것인지 입력받는다
- [x] 자동차 객체를 생성한다
  - [x] 자동차 이름이 5글자 이하인지 확인하고 잘못된 경우 IllegalArgumentException을 발생시킨다
- [x] 게임을 시행 횟수만큼 실행하고 결과를 저장한다
- [x] 게임을 1회 진행하고 결과를 저장한다
- [x] 자동차를 전진시킨다
  - [x] 무작위 값을 생성한다
  - [x] 무작위 값이 4이상일 때만 이동한다
  - [x] 결과를 저장한다
- [x] 자동차 이름을 출력한다
- [x] 우승자를 출력한다
    - [x] 우승자가 여러 명인 경우 쉼표(,)를 이용해 출력한다

## 객체 설계
### RacingGame 객체
- GameList
  - 게임의 항목을 관리하는 객체
  - GameType에 맞게 Game을 관리한다
  - Game이 늘어나면 GameType에 맞는 Game을 추가하여 관리한다
  - static Game getGame(GameType gameName) : GameType에 맞는 게임을 반환한다
- GamePlayer
  - Game을 받으면 실행하는 역할
  - void start(Game game) : Game을 받아 실행한다
- Game
  - 게임 객체
  - void play() : 해당 게임을 실행한다
- Car
  - 자동차 객체
  - void move() : 자동차를 움직인다
- Cars
  - Car 일급 컬렉션 객체
  - roundCount만큼 경기를 진행한다
  - GameResult proceedRound(PositiveNumber roundCount) : roundCount만큼 경기를 진행하고 결과를 반환한다
- MovingStrategy
  - Car 객체가 어떻게 움직일지를 결정하는 전략
  - Position getDistance() : 전략에 따라 Position을 반환한다
- RandomValueGenerator
  - 랜덤한 값을 생성하는 객체
  - PositiveNumber generate() : 랜덤한 값을 생성한다
- CarHandler
  - 이름과 시행횟수를 받아 게임을 진행하고, 결과를 반환하는 객체
  - GameResult handle(Names names, PositiveNumber roundCount)
- Name
  - 이름을 저장하는 객체
  - 이름의 길이는 MAX_NAME_LENGTH 이하이다
- Names
  - Name 일급 컬렉션 객체
- PositiveNumber
  - 음이 아닌 정수를 저장하는 객체
- Position
  - 위치를 저장하는 객체
- CustomException
  - 사용자 정의 예외
  - 요구사항에 맞게 IllegalArgumentException을 반환한다

### 입출력 객체
- InputHelper
  - 입력 로직을 수행한다
  - Names getNames() : 문자열을 입력받아 이름을 반환한다
  - PositiveNumber getTryCount() : 문자열을 입력받아 횟수를 반환한다
- OutputHelper
  - void printResult(GameResult result) : 결과를 받으면 format에 맞게 출력한다
- InputComponent
  - message를 입력받아 출력한 후 입력값을 반환하는 역할을 한다
  - String getValue(String message) : message를 출력하고 value를 입력받아 반환한다

## 고민한 사항
### 1. 패키지 구조
지난 주 과제는 계산기 인터페이스와 실질적으로 계산을 수행하는 객체를 나누어 생각했고 클라이언트-서버 구조를 생각하고 작성했다.
계산기와 다르게 게임은 수행하는 게임이 달라지게 되면 모든 부분이 변경된다 생각을 했고, Game을 인터페이스로 나누었다.
지난 주 과제와 비슷하게 MVC 구조와 비슷하게 패키지 구조를 작성하게 되었다.

CarHandler, OutputHelper, GameResult를 MVC 패턴처럼 사용하여 객체의 책임과 역할을 나누어 작성하였다.
계산기 예제는 다양한 입력이 오는 상황을 가정했기 때문에 FrontController를 사용했지만 이번 경주 게임 같은 경우
게임이 달라지면 입력이 바뀐다고 생각을 하여 별도의 FrontController를 구현하지 않았다.

### 2. 자동차 전진 방식
Car 객체 안에 움직이는 로직을 포함시키면 자동차가 움직이는 방식이 바뀌었을 때 Car라는 객체의 코드가 많이 변경된다 생각했다.
별도로 움직이는 방식을 객체로 선언하고 Car가 움직이는 방식을 나타내는 객체와 통신하게 하여 OCP를 지키려 했다.

### 2-1. 자동차 전진 방식 테스트 코드 작성
랜덤한 값을 생성하고 4이상이 되면 전진하도록 하는 테스트 코드를 작성할 때 고민을 많이 했다. private으로 되어 있는 부분을
어떻게 테스트하면 좋을지 고민이 되었고, 숫자를 생성하는 객체를 별도의 RandomValueGenerator로 작성하였다.
이렇게 객체를 분리하게 되면 테스트 코드를 작성할 때도 Mock을 사용해 편하게 test를 진행할 수 있고,
랜덤한 상수를 만드는 방식이 변경되더라도 코드 수정을 최소화할 수 있는 장점이 있었다.