# 🎯 2주차 미션 목표

## 🏗️ 단일 책임 원칙 적용
- 각 구성 요소와 메서드는 하나의 책임만 가지도록 설계하며, 맡은 역할을 명확하게 정의한다.
- 여러 역할을 수행하는 큰 함수는 단일 역할을 수행하는 작은 함수로 분리한다.


## ✅ 테스트 코드 작성 및 확인
- JUnit 5와 AssertJ를 사용하여 프로그램이 제대로 작동하는지 테스트한다.
- 테스트 도구를 사용하는 방법을 배우고 테스트를 통해 기능을 검증한다.

## 🔄 피드백 반영
- 1주 차 공통 피드백을 최대한 반영한다.

---

# 기능 요구 사항
- [x] 초간단 자동차 경주 게임을 구현한다. 🚗🏁

---

## 👨‍✈️ 자동차 경주 게임 진행

자동차 경주 게임 흐름은 게임의 전반적인 진행을 제어하는 역할을 수행한다.

### 💻  입력 처리
- [x] 사용자로부터 자동차 이름과 이동 횟수를 입력받는다.
  - [x] **자동차 이름 입력**: 쉼표(,)를 기준으로 자동차 이름을 입력받는다.
  - [x] **이동 횟수 입력**: 사용자가 몇 번 이동할 것인지 입력받는다.

### 🏁 게임 진행
- [x] 자동차 경주 게임을 진행하는 기능을 제공한다.
  - [x] **자동차 전진 조건 확인**: 무작위로 생성된 값(0-9)이 4 이상일 경우 자동차는 전진한다.
  - [x] **자동차 이동 출력**: 자동차가 전진할 때, 해당 자동차의 이름과 함께 이동 상태를 출력한다.

### 🏆 우승자 결정
- [x] 게임이 끝난 후 우승자를 결정하고 결과를 출력한다.
  - [x] **우승자 판정**: 가장 멀리 이동한 자동차를 우승자로 결정한다.
  - [x] **우승자 출력**: 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력한다.

---

## 🚙 자동차

자동차는 각자 이름을 가지고 있으며, 주어진 조건에 따라 전진하거나 멈출 수 있다.

### 🛠️ 기능 요구사항

#### 🚗 자동차 생성
- [x] **자동차 이름 설정**: 각 자동차에 5자 이하의 이름을 부여한다.

#### 🚗💨 자동차 전진
- [x] **자동차 전진 여부 결정**: 무작위 값이 4 이상일 경우 자동차는 전진한다.
  - [x] **무작위 값 생성**: 0에서 9 사이의 값을 무작위로 생성한다.

#### 🚦 자동차 정지
- [x] **자동차 정지**: 무작위 값이 4 미만일 경우 자동차는 정지한다.

---

## 🎲 무작위 값 생성

무작위 값 생성 기능은 자동차가 전진할지 여부를 결정하는 데 필요한 무작위 값을 생성하는 역할을 수행한다.

### 🛠️ 기능 요구사항

- [x] **무작위 값 생성**: 0에서 9 사이의 값을 무작위로 생성한다.
- [x] **전진 조건 확인**: 무작위 값이 4 이상일 경우, 자동차는 전진한다.

---

## 💻 입력 관리

입력 관리 기능은 사용자로부터 자동차 이름과 이동 횟수를 입력받고, 이를 검증하는 역할을 수행한다.

### 🛠️ 기능 요구사항

#### 💻 입력받기
- [x] **자동차 이름 입력**: 쉼표(,)로 구분된 자동차 이름을 입력받는다.
- [x] **이동 횟수 입력**: 사용자가 이동할 횟수를 입력받는다.

---

## 🖥️ 출력 관리

출력 관리 기능은 게임 진행 상황과 사용자에게 필요한 메시지를 화면에 출력하는 역할을 수행한다.

### 🛠️ 기능 요구사항

#### 💻 입력 메시지 출력
- [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
- [x] "시도할 횟수는 몇 회인가요?"

#### 📊 진행 결과 출력
- [x] **차수별 결과 출력**: 각 차수별로 자동차의 이동 상태와 이름을 출력한다.

#### 🏆 우승자 결과 출력
- [x] **단독 우승자 결과 출력**: 우승자가 한 명일 경우 해당 자동차의 이름을 출력한다.
- [x] **공동 우승자 결과 출력**: 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력한다.

---

## 🔍 검증 사항

자동차 경주 게임의 올바른 동작을 보장하기 위해, 각 기능에 대해 아래와 같은 검증 로직을 적용했습니다.

### ✅ 입력 검증
- [x] **잘못된 입력 처리**: 입력이 잘못되었을 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.
  - [x] **빈 문자열 여부**: 입력값이 빈 문자열인지 확인한다.
  - [x] **자동차 이름 길이 검증**: 이름이 5자 이하인지 확인한다.
  - [x] **자동차 이름 개수**: 자동차 이름이 2개 미만인지 확인한다.
  - [x] **자동차 이름 문자 검증**: 이름에 영어와 한글 이외의 문자가 포함되지 않았는지 확인한다.
  - [x] **시도 횟수 숫자 여부 검증**: 시도 횟수가 숫자인지 확인한다.
  - [x] **시도 횟수 범위 검증**: 시도 횟수가 1에서 20 사이인지 확인한다.

### 🔧 RaceProgressManager 검증 로직
- [x] **자동차 이름 중복 검증**: 동일한 이름의 자동차가 등록되지 않도록 예외를 발생시킨다.
- [x] **자동차 존재 여부 검증**: 진행 상태 업데이트 시, 등록되지 않은 자동차에 대해 예외를 발생시킨다.

### 🛠️ RacingCar 검증 로직
- [x] **MovementPolicy null 검증**: `MovementPolicy`가 null일 경우 예외를 발생시킨다.
- [x] **RaceProgressManager null 검증**: `RaceProgressManager`가 null일 경우 예외를 발생시킨다.

