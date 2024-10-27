# 🚗자동차 경주
자동차 경주 게임은 주어진 횟수 동안 여러 대의 자동차가 무작위로 전진 또는 멈추면서 이동 거리를 기록하고, 최종 우승자를 가리는 게임입니다.

## 패키지 구조
```
📦racingcar
 ┣ 📂controller
 ┃ ┗ 📜CarRaceController.java
 ┣ 📂domain
 ┃ ┗ 📜Car.java
 ┣ 📂enums
 ┃ ┣ 📜ExceptionMessage.java
 ┃ ┗ 📜Message.java
 ┣ 📂service
 ┃ ┗ 📜CarRaceService.java
 ┣ 📂util
 ┃ ┣ 📜RandomUtil.java
 ┃ ┗ 📜Validator.java
 ┣ 📂view
 ┃ ┣ 📜InputView.java
 ┃ ┗ 📜OutputView.java
 ┗ 📜Application.java
```
- `Car` : 자동차 객체를 정의하는 클래스입니다. 자동차의 이름과 이동 거리를 저장하고 전진 기능을 제공합니다.
- `CarRaceService` : 자동차 경주에 필요한 로직을 처리합니다. 자동차 전진 여부를 판단하고 최종 우승자를 결정합니다.
- `CarRaceController` : 사용자 입력과 출력을 관리하며 게임 전체 흐름을 제어합니다.
- `RandomUtil` : 랜덤 숫자를 생성합니다.
- `Validator` : 입력값의 유효성을 검사하여 잘못된 입력 시 `IllegalArgumentException`을 발생시킵니다.
- `InputView`, `OutputView` : 콘솔 입출력을 담당합니다.
- `ExceptionMessage` : 예외 상황에서 사용하는 메시지를 관리합니다.
- `Message` : 일반적인 출력 메시지를 관리합니다.

## 기능 목록
- **자동차 이름 입력 및 유효성 검사**
  - [x] 사용자에게 자동차 이름을 입력받는다.
  - [x] 자동차 이름을 쉼표로 구분하여 저장한다.
  - [x] 이름은 5자 이하만 가능하다.
  - [x] 공백 이름은 허용되지 않는다.
  - [x] 중복된 이름은 허용되지 않는다.
  - [x] 두 개 이상의 이름을 입력받아야 한다.
- **시도 횟수 입력 및 유효성 검사**
  - [x] 사용자에게 시도할 횟수를 입력받는다.
  - [x] 횟수는 소수, 0, 음수가 될 수 없다.
- **자동차 이동 및 이동 거리 관리**
  - [x] 각 시도에서 0에서 9까지의 무작위 값을 생성한다.
  - [x] 생성된 값이 4 이상일 경우 자동차가 전진하여 이동 거리에 `-`를 추가한다.
- **출력 형식**
  - [x] 시도 횟수마다 자동차 이름과 이동 거리를 출력한다.
  - [x] 게임이 완료되면 최종 우승자를 출력한다.
  - [x] 공동 우승자가 있을 경우 쉼표로 구분하여 출력한다.
- **예외 처리**
  - [x] 유효하지 않은 입력값에 대해 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.