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

- **Car 객체**: 각 자동차를 나타내는 객체
- **Winner 객체**: 우승자를 나타내는 객체
- **InputView 객체**: 사용자의 입력을 처리하는 객체
- **OutputView 객체**: 게임 결과 및 우승자 정보를 출력하는 객체
- **Validator 객체**: 입력 검증을 처리하는 객체

---

## 클래스와 패턴 매핑

- **Car 객체 (Model)**: 자동차를 나타내며, 0~9 사이의 랜덤 숫자를 가집니다.
- **Winner 객체 (Model)**: 우승자를 나타냅니다.
- **CarRacingGameController (Controller)**: 랜덤 숫자를 이용하여 자동차가 전진할지 여부를 판별하고, 단독 우승자 또는 공동 우승자를 구분합니다.
- **InputView (View)**: 사용자로부터 자동차 이름 및 시도 횟수 입력을 처리합니다.
- **OutputView (View)**: 차수별 실행 결과와 우승자를 출력합니다.
- **Validator 객체 (Controller)**: 입력 값이 유효한지 검증합니다.

---

## 클래스 네이밍

- **Car (Model)**: 자동차 객체
- **Winner (Model)**: 우승자 객체
    - **SoleWinner (Model)**: 단독 우승자 객체
    - **CoWinner (Model)**: 공동 우승자 객체
- **CarRacingGameController (Controller)**: 자동차 경주 게임 로직을 처리하는 컨트롤러
- **InputView (View)**: 입력을 처리하는 객체
- **OutputView (View)**: 출력을 처리하는 객체

---

## 패키지 구조
model
    Car
    Winner

view
    InputView
    OutputView

controller
    CarRacingGameController

