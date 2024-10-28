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
