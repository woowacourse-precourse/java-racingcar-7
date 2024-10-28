# java-racingcar-precourse

# 🚗자동차 경주 게임
## 기능 구현 목록

### 1️⃣ 입력 받기

- [x]  `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 을 활용해 사용자에게서 자동차의 이름과 이동 횟수를 입력받습니다.
    - 자동차가 여러 대일 경우, 이름은 쉼표로 구분되고 각각의 이름은 5자 이하로 제한됩니다.
- [x]  사용자가 잘못된 형식으로 입력했을 경우, `IllegalArgumentException` 를 발생시킨 후 애플리케이션을 종료합니다.

### 2️⃣  자동차 전진 여부 결정

- [x]  `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange()` 을 활용해 자동차의 수만큼 0 ~ 9 사이의 랜덤 값을 추출합니다.
- [x]  랜덤 값이 4 이상이면, 해당 자동차에 `’-’` 를 추가하며 전진함을 표시합니다.
- [x]  이를 사용자가 입력한 이동 횟수만큼 반복합니다.

### 3️⃣ 우승자 판독

- [x]  최종적으로 `‘-’` 의 개수가 가장 많은 자동차를 선정합니다.
    - 우승자는 여러 명일 수 있습니다.

### 4️⃣ 출력하기

- [x]  차수별 실행 결과를 출력합니다.
- [x]  최종 우승자의 이름을 출력합니다.
    - 우승자가 여러 명일 경우, 이름을 쉼표로 구분하여 출력합니다.


## 클래스별 기능 정리

### InputView 클래스

- **inputCar()**

  : 경주할 자동차 이름에 대한 입력을 받습니다.

   - 입력 받은 문자열에 있는 공백은 모두 지워 처리합니다.
   - 아무 것도 입력 받지 않거나 이름의 글자 수가 5가 넘어가면 예외 처리합니다.
- **inputCount()**

  : 시도할 횟수를 입력 받습니다.

   - 문자가 입력될 경우 예외 처리합니다.

### MoveDecider 클래스

- **pickRandomNum()**

  : 0부터 9까지의 수 중에서 무작위로 하나의 수를 구합니다.

- **isMovable(int randomNum)**

  : pickRandomNum()에서 구한 수가 4 이상일 때, 문자열 `moved`에  “-”를 추가합니다.

- **move(String[] carNames, int attemptCount)**

  : 각 자동차의 이동 상태를 생성하고 반환합니다.

   - 각 시도마다 generateMovementResult를 호출해 이동 결과를 갱신합니다.
- **generateMovementResult(String[] movements)**

  : 자동차의 이동 상태를 갱신하고 현재 상태를 출력합니다.


### RaceWinner 클래스

- **findWinner(String finalMovements)**

  : 가장 멀리 전진한 자동차의 이름(최종 우승자)을 출력합니다.

   - 최종 이동 상태에서 “-”의 개수가 가장 많은 자동차를 출력합니다.
   - 여러 명의 우승자도 쉼표로 구분하여 모두 출력합니다.

### RaceRunner 클래스

- **run()**

  : 자동차 경주 게임의 실행 흐름을 저장합니다.