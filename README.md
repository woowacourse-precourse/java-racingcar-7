# java-racingcar-precourse

# 자동차 경주 게임

## 기능 목록

### 게임 로직 기능
1. 0~9 랜덤 생성 기능
2. 자동차 전진하거나 멈추는 기능
3. 자동차 이름을 쉼표(,) 기준으로 구분하는 기능
4. 단독 우승자 또는 공동 우승자 구분 기능

### 입력 기능
1. 사용자가 자동차 이름을 쉼표(,)로 입력하는 기능
2. 사용자가 시도할 횟수를 입력하는 기능

### 출력 기능
1. 차수별 실행 결과 출력 기능
2. 우승자 안내 문구 출력 기능

### 검증 기능
1. 사용자가 입력한 자동차 이름이 5자 이하인지 검증하는 기능
2. 사용자가 입력한 이동 횟수가 양수인지 검증하는 기능

---

## 필요한 클래스(객체) 목록

- **Car 객체**: 각 자동차의 상태와 이동 로직을 관리하는 객체
- **CarRacingGameController 객체**: 게임의 전체 흐름을 제어하는 컨트롤러 객체
- **InputView 객체**: 사용자의 입력을  처리하는 객체
- **OutputView 객체**: 게임 진행 중 각 라운드 결과와 최종 우승자를 출력하는 객체
- **InputProcessor 객체**: 입력 값을 가공하거나 변환하는 객체
- **InputValidator 객체**: 입력된 데이터의 유효성을 검증하는 객체
- **WinnerDecision 객체**: 게임 종료 후 각 자동차의 위치를 비교하여 최종 우승자를 결정하는 객체

---

## 클래스와 패턴 매핑

- **Car 객체 (Model)**: 자동차를 나타내며, 0~9 사이의 랜덤 숫자를 가집니다.
- **CarRacingGameController (Controller)**: 게임의 전체 흐름을 관리하며, 사용자 입력 처리, 검증, 게임 로직 실행, 최종 우승자 결정을 담당합니다.
- **InputView (View)**: 사용자로부터 자동차 이름 및 시도 횟수 입력을 처리합니다.
- **OutputView (View)**: 차수별 실행 결과와 우승자를 출력합니다.
- **InputValidator 객체 (Utility)**: 사용자 입력 값이 유효한지 검증하여 잘못된 입력을 방지합니다.
- **WinnerDecision 객체 (Utility)**: 게임 종료 후 각 자동차의 position 정보를 비교하여 우승자(들)를 결정하는 로직을 제공합니다.
- **InputProcessor 객체 (View)**: InputView에서 받은 입력 값을 가공하거나 변환하여 사용 가능한 형식으로 처리합니다.

---

## 클래스 네이밍

- **Car (Model)**: 자동차 객체
- **CarRacingGameController (Controller)**: 자동차 경주 게임의 전체 흐름을 관리하는 컨트롤러 객체
- **InputView (View)**: 입력을 처리하는 객체
- **OutputView (View)**: 출력을 처리하는 객체
- **InputValidator (Utility)**: 입력 값의 유효성을 검증하는 객체
- **WinnerDecision (Utility)**: 각 자동차의 위치를 비교하여 최종 우승자를 결정하는 객체
- **InputProcessor (View)**: 입력 값을 가공하거나 변환하는 객체

---

## 패키지 구조
~~~
📦racingcar
┣ 📂controller
┃ ┗ 📜CarRacingGameController.java
┣ 📂model
┃ ┗ 📜Car.java
┣ 📂util
┃ ┣ 📜InputValidator.java
┃ ┗ 📜WinnerDecision.java
┣ 📂view
┃ ┣ 📜InputProcessor.java
┃ ┣ 📜InputView.java
┃ ┗ 📜OutputView.java
┗ 📜Application.java
~~~

