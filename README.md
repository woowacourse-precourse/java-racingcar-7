# java-racingcar-precourse

# 🚗자동차 경주 게임

## 📝구현 기능 목록 (Features)

### 1. Model
- **Car 클래스**
    - 자동차의 이름과 위치를 저장합니다.
    - 이동 조건을 판단하여 전진 여부를 결정하는 `move()` 메서드를 포함합니다.

### 2. View
- **InputView 클래스**
    - 사용자에게 자동차 이름과 시도 횟수를 입력받고, 입력값을 `Controller`에 전달합니다.
- **OutputView 클래스**
    - 각 라운드별 진행 상황과 결과를 출력합니다.
    - 최종 우승자를 출력합니다.

### 3. Controller
- **GameController 클래스**
    - 게임의 전체 흐름을 관리하며, 사용자의 입력을 통해 자동차 경주를 진행합니다.
    - `InputView`에서 받은 입력을 바탕으로 `Car` 객체 리스트를 생성하고, 라운드를 반복하며 경주를 수행합니다.
    - 매 라운드 후 `OutputView`를 통해 경과를 출력하고, 게임 종료 후 최종 우승자를 출력합니다.
    - `InputView`에서 받은 입력값이 유효하지 않은 경우 `IllegalArgumentException`을 발생시키며, 예외 메시지를 출력한 뒤 프로그램을 종료합니다.
