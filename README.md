# java-racingcar-precourse

---

## 소개
이 애플리케이션은 사용자가 입력한 자동차 이름과 시도 횟수를 기반으로 진행되는 간단한 자동차 경주 게임입니다.   
각 자동차는 주어진 횟수 동안 전진하거나 멈출 수 있으며, 전진하는 조건은 무작위로 생성된 값이 4 이상일 때입니다.

---

## 기능 요구 사항

### 자동차 이름 입력
- **자동차 이름**은 사용자가 쉼표(,)로 구분하여 입력합니다.
- 각 자동차 이름은 **5자 이하**로 제한됩니다.
- **중복된 자동차 이름**이 입력될 경우 `IllegalArgumentException` 예외가 발생합니다.

### 시도 횟수 입력
- 사용자는 자동차가 전진할 총 **시도 횟수**를 입력해야 합니다.
- 입력된 횟수는 **양의 정수**여야 하며, 빈 입력은 허용되지 않습니다.
- 예외의 경우 `IllegalArgumentException` 예외가 발생합니다.

### 자동차 전진 로직
- 각 라운드에서 각 자동차는 **0에서 9 사이의 무작위 값**을 생성하여, 이 값이 **4 이상**일 경우 전진합니다.
- 각 자동차의 현재 상태는 이름과 함께 출력됩니다.

### 경주 결과
- 경주가 완료된 후, **최종 우승자**를 발표합니다.
- 한 명 이상의 우승자가 있을 수 있으며, 이 경우 우승자 이름은 `,(쉼표)`로 구분하여 출력됩니다.

### 예외 처리
- 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`이 발생하여 애플리케이션이 종료됩니다.

## 주요 메서드 설명

### `Validator` 클래스
- **validateTryCounts(String input)**: 입력된 시도 횟수를 검증합니다. 빈 입력이나 음수 입력에 대해 예외를 발생시킵니다.
- **validateCarNames(String input)**: 입력된 자동차 이름의 유효성을 검사합니다. 중복 이름 및 길이 제한을 검증합니다.

### `InputView` 클래스
- **getCarNames()**: 사용자로부터 자동차 이름을 입력받습니다.
- **getTryCounts()**: 사용자로부터 시도 횟수를 입력받습니다.

### `OutputView` 클래스
- **displayCarNameMessage()**: 자동차 이름 입력을 안내하는 메시지를 출력합니다.
- **displayTryCountsMessage()**: 시도 횟수 입력을 안내하는 메시지를 출력합니다.
- **displayRaceProgressMessage(List<Car> carList)**: 각 라운드의 자동차 진행 상태를 출력합니다.
- **displayWinnersMessage(List<Car> winnerList)**: 최종 우승자를 출력합니다.

### `RacingService` 클래스
- **convertNamesToCars(String carNames)**: 입력된 자동차 이름을 기반으로 `Car` 객체의 리스트를 생성합니다.
- **executeRound(List<Car> carList)**: 각 자동차의 상태를 업데이트하는 라운드를 실행합니다.
- **checkWinnerList(List<Car> carList)**: 최대 거리를 달성한 자동차 리스트를 반환하여 우승자를 결정합니다.

### `Racing` 클래스
- **start()**: 경주를 시작하고, 자동차를 초기화하며, 시도 횟수를 입력받고 경주를 진행합니다.

### `Car` 클래스
- 자동차 객체의 정보를 담고 있습니다.
- 움직임에 대한 동작 처리를 진행합니다.

