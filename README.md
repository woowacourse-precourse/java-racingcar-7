# java-racingcar-precourse

# 자동차 경주

사용자가 입력한 자동차 이름들과 시도 횟수로 경주를 진행하며, 가장 많이 전진한 자동차가 우승자로 발표되는 게임입니다.
자동차 이름들은 쉼표로 구분되고, 각 이름은 5자 이하여야 합니다. 또한 각 자동차는 0에서 9 사이의 무작위 값이 4 이상일 경우 전진하며
최종 우승자가 여러 명일 경우 쉼표로 구분하여 출력합니다. 잘못된 입력이 있을 경우 `IllegalArgumentException`을 발생시키고
프로그램은 종료됩니다.

---

## 주요 클래스 설계 및 역할

### **1. Model - `Car.java`**

- **역할**: `Car` 클래스는 각 자동차의 이름과 현재 위치 상태를 관리하며, 이동 로직을 수행합니다.
- **주요 메서드**:
    - `Car(String name)`: 자동차 이름을 초기화하며 생성합니다.
    - `validateName(String name)`: 이름 유효성 검사(5자 이내, 빈값 확인).
    - `getName()`: 자동차 이름을 반환합니다.
    - `getPosition()`: 현재 위치를 반환합니다.
    - `move()`: 무작위 값이 조건을 충족할 때 위치를 증가시킵니다.
    - `canMove(int randomValue)`: 4 이상일 경우에만 이동 가능하도록 조건을 설정합니다.

### **2. View**

#### **InputView.java**

- **역할**: 사용자 입력을 받는 역할을 담당하며 자동차 이름과 시도 횟수를 입력받습니다.
- **주요 메서드**:
    - `inputCarNames()`: 쉼표로 구분된 자동차 이름을 입력받고 검증합니다.
    - `inputTrialCount()`: 시도 횟수를 입력받아 검증합니다.

#### **ResultView.java**

- **역할**: 경주 진행 상황과 최종 결과를 출력합니다.
- **주요 메서드**:
    - `printRoundResult(List<Car> cars)`: 각 라운드의 자동차 위치를 출력합니다.
    - `printCarResult(Car car)`: 개별 자동차의 현재 위치를 출력합니다.
    - `printWinners(List<Car> winners)`: 최종 우승자(들)를 출력합니다.

### **3. Controller - `RacingGameController.java`**

- **역할**: `RacingGameController`는 게임의 주요 비즈니스 로직을 담당하며, Model과 View를 연결하여 게임 흐름을 관리합니다.
- **주요 메서드**:
    - `run()`: 전체 게임의 흐름을 관리합니다.

### **4. Service - `RacingGameService.java`**

- **역할**: 주요 로직을 처리하는 역할을 담당합니다. 자동차 생성과 우승자 판단 등의 로직을 포함하며, `RacingGameController`와 협력하여 게임의 비즈니스
  로직을 수행합니다.
- **주요 메서드**
    - `validateCarNames(String[] carNames)`: 자동차 이름 배열을 받아 중복 여부를 검사합니다. 중복이 있을 경우
      IllegalArgumentException을 발생시킵니다.
    - `validateTrialCount(int trialCount)`: 시도 횟수가 1 이상인지 확인합니다. 조건에 맞지 않을 경우
      IllegalArgumentException을 발생시킵니다.
    - `createCars(String[] carNames)`: 입력받은 이름 배열을 기반으로 Car 객체 리스트를 생성합니다.
    - `playRound(List<Car> cars)`: 주어진 자동차 리스트에서 각 자동차가 무작위 조건에 따라 전진할 수 있는지 검사하고, 조건에 맞으면 이동시킵니다.
    - `findWinners(List<Car> cars)`: 가장 많이 전진한 자동차를 우승자로 선정하며, 여러 대일 경우 공동 우승 처리합니다.

### **5. Constants - `Constants.java`**

- **역할**: 게임 전반에 걸쳐 사용하는 상수들을 한 곳에 모아 관리합니다.
- **주요 상수**:
    - `GET_CAR_NAME_MESSAGE`: 자동차 이름 입력 안내 메시지.
    - `GET_TRIAL_MESSAGE`: 시도 횟수 입력 안내 메시지.
    - `INTERMEDIATE_RESULT_MESSAGE`: 각 라운드 결과를 출력하는 메시지.
    - `FINAL_RESULT_MESSAGE`: 최종 결과를 출력하는 메시지.

### **6. Main - `Application.java`**

- **역할**: 게임의 시작점입니다. `RacingGameController` 인스턴스를 생성하고 의존성을 주입한 뒤, `run()` 메서드를 호출하여 게임을 시작합니다.