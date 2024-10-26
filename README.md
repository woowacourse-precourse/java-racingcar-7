# java-racingcar-precourse
## 기능 요구 사항에 기재되지 않은 상황에 대한 정의

### 1. 이름은 어떤 문자들로 구성되어야 하는지?

  (영문만, 숫자나 한글도 포함, 특수 문자도 포함 등등)

  **→ 알파벳과 숫자로만 구성되도록 제한.**

### 2. 이동할 횟수의 하한, 상한

  **→ 최소 1회에서부터 최대 100회까지로 제한.**

### 3. 경주할 자동차 이름이 하나만 입력된 경우에 대한 처리
  **→ 경주할 자동차의 수는 반드시 2대 이상이어야 하도록 설정. 하나만 입력된 경우 예외 발생하도록 함.**

## 기능 목록

## RacingGame 클래스

int limit: 시도되어야 할 전체 횟수<br>
List\<Car> participants: 경주에 참가한 자동차의 목록

public playGame()
: \: 자동차 경주 게임 전체를 진행하는 메소드

- [ ]  for (int curr = 0; curr < limit; curr++)
    - [ ]  playSingleRound() 호출해 라운드 진행
    - [ ]  UI.printRoundResult() 호출해 현재 라운드의 결과 출력
- [ ]  반복이 끝나면 Utils.countWinners() 호출해 결과 집계
- [ ]  UI.printWinners() 호출해 결과 출력

private void playSingleRound()
: \: 하나의 라운드를 진행하는 메소드.

- [x]  participants의 각 요소들에 접근
- [x]  Utils.canMove() 호출해 전진 가능 여부 확인
- [x]  Car.moveOrStop()를 호출하고, 매개변수로 전진 가능 여부를 넘겨 줌으로써 전진 혹은 멈춤 수행

## Car 클래스

String name: 자동차의 이름<br>
int movedCnt: 현재까지 전진한 횟수

public void moveOrStop(boolean canMove)
: \: canMove 값에 따라 자신을 전진 혹은 멈춤시키는 메소드.

- [x] canMove true인지 확인
   - [x] true라면 자신의 movedCnt를 1 증가

## Utils 클래스

public List\<Car> setParticipants(String[] splited)
: \: 입력받은 자동차 이름을 바탕으로 Car 인스턴스를 생성하는 메소드.

- [x]  splited의 각 요소들에 접근
- [x]  자동차 이름으로 Car 인스턴스 생성한 후 리스트에 추가
- [x]  생성된 Car 인스턴스의 리스트를 리턴

public boolean canMove()
: \: 랜덤 값을 추출해 반환하는 메소드.

- [x]  `amp.nextstep.edu.missionutils.Randoms`의`pickNumberInRange()` 을 활용해 0에서 9 사이의 랜덤 값 추출
- [x]  해당 랜덤 값이 4 이상이면 true, 3 이하이면 false 리턴

public List\<String> countWinners(List\<Car> participants)
: \: 우승자를 집계하는 메소드.

- [ ]  participants를 movedCnt 값을 기준으로 내림차순 정렬
- [ ]  가장 movedCnt 값이 높은 자동차(들)를 리스트에 저장해 리턴

## Validation 클래스

public String[] validateCarName(String input)
: \: 입력받은 자동차 이름이 요구 사항에 맞는지 확인하는 메소드.

- [x]  input에 쉼표가 포함되어 있지 않으면 자동차가 한 대뿐이므로 예외 발생
- [x]  split()을 사용하여 input을 쉼표 기준으로 분할
- [x]  분할된 배열 요소들에 하나씩 접근
    - [x]  이름이 6자 이상이거나, 알파벳이나 숫자 외에 다른 문자를 포함하는 경우 예외 발생
- [x]  예외가 발생하지 않은 경우 분할된 String 배열을 리턴

public int validateRoundLimit(String input)
: \: 입력받은 시도 횟수 값이 요구 사항에 맞는지 확인하는 메소드.

- [x]  input을 정수로 변환
- [x]  input이 숫자 형태가 아니거나, 양의 정수가 아니거나, 100 초과인 경우 예외 발생
- [x]  예외가 발생하지 않았다면 정수로 변환된 input을 리턴

## UI 클래스

public String[] getCarNames()
: \: 경주할 자동차 이름을 입력받는 메소드.

- [x]  `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 메시지 출력
- [x]  `camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용해 자동차 이름을 입력받기
- [x]  Validate.validateCarName() 호출해 입력 받은 값 검증
- [x]  입력받은 값에 문제가 없다면 해당 입력 값이 분할된 결과를 리턴

public int getRoundLimit()
: \: 경주 시도 횟수를 입력받는 메소드.

- [x]  `시도할 횟수는 몇 회인가요?` 메시지 출력
- [x]  `camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용해 시도할 횟수 입력받기
- [x]  Validate.validateRoundLimit() 호출해 입력받은 값 검증
- [x]  입력받은 값에 문제가 없다면 해당 입력 값을 정수로 변환한 값을 리턴

public void printRoundResult(boolean isFirstRound, List\<Car> participants)
: \: 각 라운드의 결과를 출력하는 메소드.

- [x]  isFirstRound가 true이면 `실행 결과` 메시지 출력
- [x]  participants의 각 요소에 하나씩 접근
    - [x]  (자동차 이름) : (전진 횟수만큼의 -) 형태로 출력

public void printWinners(List\<String> winners)
: \: 모든 라운드 종료 후 최종 우승자를 출력하는 메소드.

- [ ]  `최종 우승자 :` 메시지 출력
- [ ]  winners의 각 요소를 하나씩 출력
    - [ ]  현재 출력하고자 하는 자동차의 이름이 winners의 마지막 요소가 아니라면 뒤에 ‘, ‘를 추가로 출력