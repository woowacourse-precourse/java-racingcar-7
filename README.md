# java-racingcar-precourse
## 기능 요구 사항에 기재되지 않은 상황에 대한 정의

### 1. ~~이름을 구성하는 문자의 종류~~

  ~~(영문만, 숫자나 한글도 포함, 특수 문자도 포함 등등)~~

  ~~**→ 알파벳과 숫자로만 구성되도록 제한.**~~

~~한글이나 기타 특수 문자 포함 시 인코딩 문제가 발생할 가능성이 있음.~~

**알파벳과 숫자로만 구성되도록 제한하니 지원 페이지의 예제 테스트가 통과하지 않아 문자 종류에 제한을 두지 않도록 구현을 변경함.**

### 2. 이동할 횟수의 하한, 상한

  **→ 최소 1회에서부터 최대 100회까지로 제한.**

게임을 0회 진행하는 것은 자동차 게임을 진행하는 프로그램의 목적에 맞지 않음.

게임 진행 횟수가 지나치게 많으면 시스템 부하 발생 가능성이 있으며, int 타입의 범위를 벗어날 우려 존재.

### 3. 경주할 자동차 이름이 하나만 입력된 경우에 대한 처리
**→ 경주할 자동차의 수는 반드시 2대 이상이어야 하도록 설정. 하나만 입력된 경우 예외 발생하도록 함.**

자동차 한 대로 기능을 수행하는 것은 자동차 게임이라는 프로그램의 목적에 맞지 않음.

### 4. 중복된 자동차 이름이 존재할 경우 대한 처리
**→ 경주할 자동차의 이름은 반드시 서로 달라야 하도록 설정. 중복되는 이름이 존재하는 입력에 대해서는 예외 발생하도록 함.**

같은 자동차 이름이 존재하면 결과 출력 시 구분할 수 없음.

### 5. 0에서 9 사이는 0 이상 9 이하일까? 1 이상 8 이하일까?
`전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.`

**→ 0 이상 9 이하로 가정.**

전진할 확률과 멈춰 있을 확률 간의 차를 비교하면 전자가 더 작으므로 전자가 더 공정하다고 판단.

## 기능 목록

### RacingGame 클래스

int limit: 시도되어야 할 전체 횟수<br>
List\<Car> participants: 경주에 참가한 자동차의 목록

**public void setParticipants(String[] splited)**

\: 입력받은 자동차 이름을 바탕으로 Car 인스턴스를 생성하는 메소드.

- [x]  splited의 각 요소들에 접근
- [x]  자동차 이름으로 Car 인스턴스 생성한 후 participants 추가

**public playGame()**

\: 자동차 경주 게임 전체를 진행하는 메소드

- [x]  for (int curr = 0; curr < limit; curr++)
    - [x]  playSingleRound() 호출해 라운드 진행
    - [x]  OuputView.printRoundResult() 호출해 현재 라운드의 결과 출력
- [x]  반복이 끝나면 Utils.getWinners() 호출해 결과 집계
- [x]  OuputView.printWinners() 호출해 결과 출력

**private void playSingleRound()**

\: 하나의 라운드를 진행하는 메소드.

- [x]  participants의 각 요소들에 접근
- [x]  Utils.canMove() 호출해 전진 가능 여부 확인
- [x]  Car.moveOrStop()를 호출하고, 매개변수로 전진 가능 여부를 넘겨 줌으로써 전진 혹은 멈춤 수행

### Car 클래스

String name: 자동차의 이름<br>
int movedCnt: 현재까지 전진한 횟수

**public void moveOrStop(boolean canMove)**

\: canMove 값에 따라 자신을 전진 혹은 멈춤시키는 메소드.

- [x] canMove true인지 확인
   - [x] true라면 자신의 movedCnt를 1 증가

### Utils 클래스

**public boolean canMove()**

\: 랜덤 값을 추출해 반환하는 메소드.

- [x]  `amp.nextstep.edu.missionutils.Randoms`의`pickNumberInRange()` 을 활용해 0에서 9 사이의 랜덤 값 추출
- [x]  해당 랜덤 값이 4 이상이면 true, 3 이하이면 false 리턴

**public List\<String> getWinners(List\<Car> participants)**

\: 우승자를 집계하는 메소드.

- [x]  participants를 movedCnt 값을 기준으로 내림차순 정렬
- [x]  가장 movedCnt 값이 높은 자동차(들)를 리스트에 저장해 리턴

### Validation 클래스

**public String[] validateCarName(String input)**

\: 입력받은 자동차 이름이 요구 사항에 맞는지 확인하는 메소드.

- [x]  input에 쉼표가 포함되어 있지 않으면 자동차가 한 대뿐이므로 예외 발생
- [x]  split()을 사용하여 input을 쉼표 기준으로 분할
- [x]  중복된 자동차 이름이 존재하는 경우 예외 발생
- [x]  분할된 배열 요소들에 하나씩 접근
    - [x]  이름이 6자 이상인 경우 예외 발생
- [x]  예외가 발생하지 않은 경우 분할된 String 배열을 리턴

**public int validateRoundLimit(String input)**

\: 입력받은 시도 횟수 값이 요구 사항에 맞는지 확인하는 메소드.

- [x]  input을 정수로 변환
- [x]  input이 숫자 형태가 아니거나, 양의 정수가 아니거나, 100 초과인 경우 예외 발생
- [x]  예외가 발생하지 않았다면 정수로 변환된 input을 리턴

### InputView 클래스

**public String[] getCarNames()**

\: 경주할 자동차 이름을 입력받는 메소드.

- [x]  `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 메시지 출력
- [x]  `camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용해 자동차 이름을 입력받기
- [x]  Validate.validateCarName() 호출해 입력 받은 값 검증
- [x]  입력받은 값에 문제가 없다면 해당 입력 값이 분할된 결과를 리턴

**public int getRoundLimit()**

\: 경주 시도 횟수를 입력받는 메소드.

- [x]  `시도할 횟수는 몇 회인가요?` 메시지 출력
- [x]  `camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용해 시도할 횟수 입력받기
- [x]  Validate.validateRoundLimit() 호출해 입력받은 값 검증
- [x]  입력받은 값에 문제가 없다면 해당 입력 값을 정수로 변환한 값을 리턴

### OutputView 클래스

**public void printRoundResult(boolean isFirstRound, List\<Car> participants)**

\: 각 라운드의 결과를 출력하는 메소드.

- [x]  isFirstRound가 true이면 `실행 결과` 메시지 출력
- [x]  participants의 각 요소에 하나씩 접근
    - [x]  (자동차 이름) : (전진 횟수만큼의 -) 형태로 출력

**public void printWinners(List\<String> winners)**

\: 모든 라운드 종료 후 최종 우승자를 출력하는 메소드.

- [x]  `최종 우승자 :` 메시지 출력
- [x]  winners의 각 요소를 하나씩 출력
    - [x]  현재 출력하고자 하는 자동차의 이름이 winners의 마지막 요소가 아니라면 뒤에 ‘, ‘를 추가로 출력