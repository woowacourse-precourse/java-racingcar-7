# java-racingcar-precourse

# 자동차 경주

사용자가 입력한 자동차 이름들과 시도 횟수로 경주를 진행하며, 가장 많이 전진한 자동차가 우승자로 발표되는 게임입니다. 
자동차 이름들은 쉼표로 구분되고, 각 이름은 5자 이하여야 합니다. 또한 각 자동차는 0에서 9 사이의 무작위 값이 4 이상일 경우 전진하며 
최종 우승자가 여러 명일 경우 쉼표로 구분하여 출력합니다. 잘못된 입력이 있을 경우 `IllegalArgumentException`을 발생시키고 
프로그램은 종료됩니다.

---
### **구조 설명**

- **Model**: `Car`는 자동차의 상태와 이동 로직을 담당합니다.
- **View**: `InputView`는 입력을, `ResultView`는 결과 출력을 담당합니다.
- **Controller**: `RacingGameController`는 게임의 흐름을 제어하며 Model과 View를 연결합니다.
- **Constants**: 메시지 및 출력 형식을 관리하는 상수들을 모아둔 클래스입니다.

---


### **1. Model - Car.java**

- **역할**: 자동차 객체를 생성하고 이동 로직을 처리합니다.
- **주요 메서드**:
    - `Car(String name)`: 자동차 객체 생성.
    - `validateName(String name)`: 이름 유효성 검사.
    - `getName()`: 자동차 이름 반환.
    - `getPosition()`: 현재 위치 반환.
    - `move()`: 위치 이동.
    - `canMove()`: 이동 조건 설정.
---
### **2. View**

### **InputView.java**

- **역할**: 사용자로부터 입력을 받습니다.
- **주요 메서드**:
    - `inputCarNames()`: 자동차 이름 입력 및 split 처리.
    - `inputTrialCount()`: 시도 횟수 입력.

### **ResultView.java**

- **역할**: 경주 결과를 출력합니다.
- **주요 메서드**:
    - `printRoundResult(List<Car> cars)`: 각 라운드의 결과 출력.
    - `printCarResult(Car car)`: 개별 자동차 결과 출력.
    - `printWinners(List<Car> winners)`: 최종 우승자 출력.

---
### **3. Controller - RacingGameController.java**

- **역할**: 게임의 비즈니스 로직을 담당하고, Model과 View를 연결합니다.
- **주요 메서드**:
    - `run()`: 게임의 전체 흐름을 관리.
    - `createCars(String[] carNames)`: 자동차 객체 리스트 생성.
    - `playRound(List<Car> cars)`: 한 라운드의 이동 로직 실행.
    - `findWinners(List<Car> cars)`: 우승자 찾기.
  
---
### **4. 상수 관리 - Constants.java**

- **역할**: 게임에서 사용하는 상수들을 모아둔 클래스.
- **주요 상수**:
    - `GET_CAR_NAME_MESSAGE`: 자동차 이름 입력 메시지.
    - `GET_TRIAL_MESSAGE`: 시도 횟수 입력 메시지.
    - `ENTER_MESSAGE`: 줄바꿈 문자.
    - `INTERMEDIATE_RESULT_MESSAGE`: 개별 중간 결과 출력 메시지.
    - `FINAL_RESULT_MESSAGE`: 최종 결과 출력 메시지.
---
### **5. Main - Application.java**

- **역할**: 게임의 시작점으로 `RacingGameController`를 실행합니다.

