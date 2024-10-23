# java-racingcar-precourse

## 요구사항 분석

자동차들은 여러대가 존재할 수 있고, 전진하거나 멈출 수 있다.

- 자동차들은 forward() 할 수 있다.

각 자동차는 이름을 가진다.

- 자동차들은 name을 가진다.

전진하는 각 자동차는 이름을 같이 출력한다.

- 자동차들을 출력할 때는 이름 함께 출력한다.

자동차 이름은 쉼표 `,` 를 기준으로 구분하며, 이름은 5자 이하만 가능하다.

- 자동차들의 이름을 파싱할때, 이를 쉼표 기준으로 분리하며, 이름은 5자 이하만 가능하도록 한다.

사용자는 몇 번의 이동을 할 것인지 입력할 수 있다.

- 사용자는 게임의 라운드 수를 지정할 수 있다.

전진하는 조건은 0~9사이의 무작위 값을 구하고 만약 4 이상인 경우 전진하게 된다.

- 자동차의 forward()는 무작위값을 추출해 4 이상이라면 전진한다.

게임 종료 후 누가 우승한지 출력하며, 우승자는 여러명일 수 있다.

- 우승자는 여러명 즉, List로 표현한다.

여러명의 우승자인 경우 쉼표를 기준으로 구분한다.

- 우승자들을 출력할 때 쉼표를 기준으로 구분한다.

### 검증해야할 상황

1. 입력값에서 쉼표(`,`)를 기준으로, 자르고 이름이 5 이하인지 검증
2. 자동차 이름이 중복으로 들어오는 경우 검증

### 변할 수 있는 값 (확장될 수 있는가?)

자동차가 아닌 다른 러너로 변경될 수 있지 않을까?

게임의 규칙이 바뀔 수 있지 않을까?

게임을 상태를 기록하는 형식이 바뀔 수 있지 않을까?


# 요구사항 설계

### 1. Model

> 뷰와 Service 간의 데이터를 위한 클래스를 가지고 있는 패키지
> 

- [ ] 1. **Racingable (인터페이스)**

- void forward() : 전진하는 메서드
- String generateState() : 상태를 생성해 반환한다.

- [ ] 2. **Car : 자동차를 표현하는 클래스**

- 멤버 변수
    - String name : 러너의 이름
    - int forwardMoveCount : 이동 횟수 (전진 횟수)
    - String moveLine : 이동 횟수에 따른 선
- 메서드
    - void forward() : 러너를 앞으로 한 칸 이동한다.
    - String generateState() : 러너의 현재 상태를 반환한다.


- [ ] 3. **GameState : 한 라운드 게임의 상태**

- 멤버 변수
    - List<String> runnersState : 러너들의 상태
- public 메서드
    - void recordState(String state) : 게임의 상태를 기록한다.
    1. runnersState에 add()한다.
    - String getState() : 게임의 상태를 반환한다.
    1. StringBuilder 객체를 만든다.
    2. runnersState를 돌면서, 문자열을 StringBuilder에 append()한다.
    3. StringBuilder.toString()으로 반환한다.

- [ ] 4. **GameHistory : 게임의 기록을 표현하는 인터페이스**

- void recordHistory(List<Racingable> runners) :
- String getHistory() :

- [ ] 5. **BasicGameHistory : 베이직 게임의 기록을 표현하는 클래스**

- 멤버 변수
    - List<GameState> states : 게임의 기록들
- public 메서드
    - void recordHistory(List<Racingable> runners) : 러너들의 상태를 기록한다.
    1. GameState 객체를 생성한다.
    2. runners들을 돌면서 다음을 수행한다.
    3. runners들의 recordState()를 호출하고 이를 GameState의 recordState() 메서드로 기록한다.
    4. 만들어진 GameState 객체를 states에 저장한다.
    - String getHistory() : 게임을 기록을 반환한다.
    1. StringBuilder 객체를 만든다.
    2. GameState를 돌면서, getState() 메서드를 통해 문자열로 만들고 이를 StringBuilder에 append()한다.
    3. StringBuilder.toString()으로 반환한다.

- [ ] 6. **GameModel : 게임을 출력하거나 진행하는데 필요한 데이터를 담고 있는 클래스**

- 멤버 변수
    - String runnerNames : 자동차 이름들
    - int gameRound : 게임 라운드 수
    - List<Racingable> racingRunners : 참여하는 러너들
    - GameHistory history : 게임의 기록
    - List<Racingable> winners : 우승자들
- 메서드
    - setrunnerNames, getrunnerNames
    - setGameRound, getGameRound
    - setRacingRunners, getRacingRunners
    - addGameHistory, getGameResult
    - selectWinners, getWinners


### 2. View Package

> 사용자에게 값을 받아오거나, 화면을 출력하는 일을 수행한다.
> 

- [ ] 1. **RacingGameView : 경주 게임의 입력, 게임의 결과를 출력하는 뷰 인터페이스**

- void inputRunnerNames(GameModel model) : 러너들의 이름을 입력받는 메서드
- void inputGameRound(GameModel model) : 게임의 라운드 수를 입력받는 메서드
- void outputGameHistory(GameModel model) : 게임의 기록을 유저에게 출력하는 메서드
- void outputGameWinners(GameModel model) : 게임의 우승자들을 유저에게 출력하는 메서드

- [ ] 2. **CarRacingGameView : 자동차 경주 게임의 입력, 게임의 결과를 출력한다.**

- 멤버 변수
    - private static final String INPUT_RUNNERS_STRING : 러너들의 이름을 입력받기 위해 유저에게 출력하는 문자열 상수
    - private static final String INPUT_ROUND_STRING : 게임의 라운드 수를 유저에게 입력받기 위해 유저에게 출력하는 문자열 상수
    - private static final String OUTPUT_GAME_STRING : 게임의 기록을 유저에게 출력할 때, 변하지 않는 문자열 위한 상수
    - private static final String OUTPUT_WINNERS_STRING : 게임의 우승자를 유저에게 출력할 때, 변하지 않는 문자열을 위한 상수
- public 메서드
    - inputRunnerNames(GameModel model) : 러너들의 이름을 사용자로부터 입력받는 메서드
    1. INPUT_RUNNERS_STRING을 사용자에게 출력한다.
    2. 사용자의 입력을 Console.readLine()으로 입력받아 model에 저장한다.
    - inputGameRound(GameModel model) : 게임의 라운드를 사용자로부터 입력받는 메서드
    1. INPUT_ROUND_STRING을 사용자에게 출력한다.
    2. 사용자의 입력을 Console.readLine()으로 입력받아 model에 저장한다.
    - outputGameHistory(GameModel model) : 게임의 기록을 사용자에게 출력하는 메서드
    1. GameModel의 getGameResult 메서드를 호출하여 출력한다.
    - outputWinners(GameModel model) : 게임의 우승자를 출력하는 메서드
    1. GameModel의 getWinners 메서드를 호출하여 출력한다.

### 3. Service Package

> 비즈니스 로직을 가지고 있는 패키지
> 

- [ ] 1. **RacingGame : 레이싱 게임 인터페이스**

- public 메서드
    - startGame(GameModel model)

- [ ] 2. **BasicRacingGame :  베이직 레이싱 게임을 진행하고 결과를 저장한다.**

- 멤버 변수
- public 메서드
    - startGame(GameModel model)
    1. model의 횟수만큼 반복한다.
    2. 러너들을 돌면서 다음을 실행한다.
    3. isForward() 메서드를 실행하고 true라면 해당 러너의 forward() 메서드를 호출한다.
    4. GameHistory의 recordHistory() 메서드를 호출하여 러너들의 상태를 기록한다.
- private 메서드
    - isForward(Car car);

- [ ] 3. **RacingRunnerGenerator** 인터페이스 : 레이싱 러너들을 생성하는 클래스

- public 메서드
    - generateVehicle(GameModel model)

- [ ] 4. **RacingCarGenerator : 레이싱 게임의 자동차에 관련된 서비스**

- 멤버 변수
- public 메서드
    - generateCars(GameModel model)
    1. 이름을 `,` 로 분리하여 String[]을 만든다.
    2. 각 이름들을 이용해서 자동차를 만든다.
- private 메서드
    - isValid(String VehicleNames)



### 4. Controller Package

> 비즈니스 로직과 뷰를 제어하는 컨트롤러가 있는 패키지
> 

- [ ] 1. **GameController : GameView와 비즈니스 로직을 제어한다.**

- 멤버 변수
    - RacingGameView
    - RacingGame
    - RacingRunnerGenerator
- public 메서드
    - run() : 게임 컨트롤러를 실행한다.
    1. RacingGameView의 inputRunnerNames 메서드를 호출하여 사용자의 입력을 받는다.
    2. RacingVehicleGenerator의 generateVehicle 메서드를 호출하여 차량들을 만든다.
    3. RacingGame의 startGame()을 호출하여 게임을 시작한다. 
    4. RacingGameView의 outputHistory 메서드를 호출하여 사용자에게 게임의 기록을 출력한다.
    5. RacingGameView의 outputWinners 메서드를 호출하여 사용자에게 게임의 우승자를 출력한다.