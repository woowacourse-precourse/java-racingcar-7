# java-racingcar-precourse

# 학습 목표

---
+ 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
  + [ ] service 와 domain 역할 명확하게 구분하기
  + [ ] controller 역할 명확하게 구분하기
+ 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
  + [ ] TDD 적용해보기
+ 1주 차 공통 피드백을 최대한 반영한다.
  + [ ] 요구사항 정확하게 준수하기
    + [ ] indent depth를 3이 넘지 않게 구현할 것.
    + [ ] 3항 연산자를 사용하지 않는다.
  + [ ] Git으로 관리할 자원 고려하기
  + [ ] 커밋 메시지를 의미있게 작성하기
  + [ ] 클래스와 메서드 이름을 한 두 단어로 유지하려고 노력하기


## 요구사항 분석

---
> 초간단 자동차 경주 게임을 구현한다.

### 기능 요구 사항
+ **주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.**
  + 횟수가 주어진다.
  + 자동차는 n대가 있다.
  + 자동차는 전진, 혹은 멈추는 상태를 가진다.
+ **각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.**
  + 각 자동차는 이름을 가지고 있다.
  + 자동차를 출력할 때는 이름이 같이 출력되어야 한다.
+ **자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.**
  + `,` 쉼표를 기준으로 구분이 된다.
  + 자동차 이름은 5자 이하만 가능하다.
+ **사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.**
  + 이동 횟수는 사용자가 정한다.
+ **전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.**
  + 전진은 무작위 값에 의해서 정해진다.
  + 무작위 값이 `4` 이상일 경우 전진한다.
  + 무작위 값이 `4` 미만일 경우 정지한다.
+ **자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.**
  + 경주가 종료 되면 우승자를 출력한다.
  + 우승자는 다수 일 수 있다.
+ **우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.**
  + 우승자가 한 명일 경우 쉼표를 출력하지 않는다. 
  + 우승자를 출력할 때 쉼표를 이용해서 구분해야 한다.
+ **사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.**
  + 잘못된 입력값이 존재한다.

# 🛠️ 기능 목록

## 🕹️ controller

---

### 🕹️RacingController
- [ ] 싱글톤으로 설계
- [ ] 등록정보를 입력받는다.
- [ ] 경기를 준비한다.
    - [ ] 경기 세팅을 맡을 RacePrepService를 생성한다.
    - [ ] 경기를 생성을 맡을 RaceArenaService를 생성한다.
        - [ ] RaceArenaService 에 RacePrepService를 주입한다.
    - [ ] RaceArenaService 에서 준비된 경기를 만든다.
- [ ] Lap이 진행되는 방식을 설정한다.
    - [ ] LapUpdateService를 주입한다.
- [ ] Race를 업데이트 한다.

### 🕹ScreenController
- [ ] 싱글톤으로 설계
- [ ] Race를 입력 받는다
- [ ] ScoreBoard를 업데이트할 방식을 설정한다.
- [ ] ScoreBoard를 업데이트 한다.
    - [ ] LapScore 를 입력받는다.
    - [ ] Lap 동안 있던 정보를 출력한다.
- [ ] 승자를 출력한다.

### 🕹InputController
- [ ] 싱글톤으로 설계
- [ ] Registeration 객체를 만들어 반환

### 🕹TotalController
- [ ] 싱글톤으로 설계
- [ ] 새로운 레이스를 만든다.
    - [ ] 입력을 받는다.
    - [ ] 경기 준비를 한다.
- [ ] 중계 서버와 연결해서 출력할 준비를 한다.
- [ ] 경기를 진행한다.
    - [ ] 경기 상태를 변화시킨다.
    - [ ] 경기 상태을 출력한다.
- [ ] 승자를 출력한다.
    - [ ] 승자를 구분한다.
    - [ ] 승자를 출력한다.

## 🛖 domain

---

### 🛖 Input
- [x] 값을 입력 받는다.
- [x] 값을 반환한다.

### Car(인터페이스)
- [x] 가속한다.
- [x] 이름을 반환한다.
- [x] 이동거리를 반환한다.

### 🛖 RacingCar
- [x] 생성 시 이름, 위치 값, 기름 량, 엔진을 입력받는다.
- [x] 가속한다.
    - [x] 엔진 출력 만큼 위치 값을 더한다.
    - [x] 엔진 기름 소모량만큼 기름 값을 뺀다.
- [x] 가속 할 수 있는 상태인지 확인한다.
    - [x] 잔여 기름 량보다 엔진 소모 기름 량이 적을 것
- [x] 이름을 반환한다.
- [x] 주행거리를 반환한다.
- [x] 기름 잔량을 반환한다.
- [x] 엔진을 반환한다.

### 🛖 Engine
- [x] 생성 시 출력(이동거리), 기름 소모량을 입력 받는다.
- [x] 출력(이동거리)를 반환한다.
- [x] 기름 소모량을 반환한다.

### 🛖 Paddock
- [ ] 생성 시, 경주에 참여하는 자동차 객체 리스트를 입력받는다.
- [ ] 경주에 참여하는 자동차 객체 리스트를 반환한다.

### 🛖 Race
- [ ] 생성 시, 경주 준비가 완료된 자동차 객체 리스트를 입력받는다.
- [ ] 생성 시, 남은 Lap 횟수(시도할 횟수)를 입력받는다.
- [ ] Lap 횟수(시도할 횟수)를 하나 줄인다.
- [ ] Lap 횟수(시도할 횟수)를 반환한다.
- [ ] 경주에 참여중인 자동차 객체 리스트를 반환한다.

### 🛖 LapScore
- [ ] 생성 시, 자동차 이름을 입력받는다.
- [ ] 생성 시, 시각화 된 이동거리를 입력받는다.
- [ ] 자동차 이름을 반환한다.
- [ ] 시각화 된 이동거리(점수)를 반환한다.

### 🛖 Registration
- [x] 생성 시, 등록되는 자동차 이름 리스트를 입력받는다.
- [x] 생성 시, LapCount(시도할 횟수)를 입력받는다.
- [x] 자동차 이름 리스트를 반환한다.
- [x] LapCount(시도할 횟수)를 반환한다.

## 🤵️service

--- 

### 📁 Constant

**상수 값을 모아둘 곳**

#### 🛖 ExpressionFormat
- [x] 구분자
- [x] 유령 자동차
- [x] 숫자로만 구성(정규식)
- [x] 승자 구분자

### 📁 input
####  🤵InputService
- [x] 입력 받은 값으로 Input 객체를 만들어 반환한다.

#### 🤵Validation
- [x] 빈 입력 검증(공용)
- [x] 자동차 이름 관련 검증
    - [x] 지정된 최대 이름 길이를 넘어간 자동차가 포함되어 있는지
    - [x] 동일한 자동차 명이 포함되어 있는지
    - [x] 유령 자동차(빈 자동차 명)이 포함되어 있는지
      - [x] 중간
      - [x] 맨 처음
      - [x] 끝 부분
- [x] 시도할 횟수 관련 입력 검증
    - [x] 숫자가 아닌 다른 문자가 포함되어 있는지
    - [x] 너무 큰 숫자가 포함되어 있는지
    - [x] 최소 시도 횟수보다 작은 값이 입력 되었는지

---
### 📁 prep

#### 🤵 EngineService
- [ ] 입력 받은 엔진 성능과 기름 소모량으로 새 엔진 객체를 만들어 반환한다.
#### 🤵 PaddockService
- [ ] 등록 정보가 담긴 객체를 입력받는다.
- [ ] 등록 정보 객체를 기반으로 경기에 참여할 자동차 객체 리스트를 생성한다.
    - [ ] 자동차 이름
    - [ ] 기름 량
    - [ ] 조율된 엔진
- [ ] 경기 참여 자동차 객체 리스트를 담은 Paddock (`레이스를 위해 대기 중인 공간`) 객체를 반환한다.
#### 🤵 RacePrepService
- [ ] 생성 시 PaddockService를 주입받는다.
- [ ] 경기 참여 준비 완료된 자동차 객체 리스트를 반환한다.
- [ ] 새 경기 객체를 만들고 반환한다.
    - [ ] 등록 정보로 Lap Count를 주입한다.
    - [ ] 경기 참여 준비 완료된 자동차 객체 리스트를 주입한다.
---
### 📁 race

#### 🤵 LapScoreService

- [ ] 자동차 객체 리스트를 입력 받는다.
- [ ] 자동차 점수 객체 리스트를 생성한다.
- [ ] 자동차 객체 리스트를 자동차 점수 객체 리스트로 변환한다.
    - [ ] 자동차의 이동거리 만큼 정해진 표시기호를 반복하는 문자열 생성한다.
    - [ ] 자동차 점수 객체를 생성한다.
        - [ ] 자동차 이름 주입한다.
        - [ ] 시각화된 자동차 이동 거리(문자열) 주입한다.
    - [ ] 자동차 점수 객체 리스트에 더한다.
- [ ] 자동차 점수 객체 리스트를 반환한다.
#### 🤵 LapUpdateService
- [ ] 생성 시, racerService 를 생성한다.
- [ ] Race 객체를 입력 받는다.
- [ ] Lap 을 진행한다.
    - [ ] Race 객체의 경기 참여 자동차 객체의 상태를 변화시킨다.
#### 🤵 RaceArenaService
- [ ] 생성 시, RacePrepService를 입력받는다.
- [ ] 생성 시, 경기 등록 정보 객체를 입력 받는다.
- [ ] 경기 등록 정보를 기반으로 RacePrepService 를 동작시켜 새로운 경기 객체를 생성한다.
#### 🤵 WinnerService
- [ ] 입력 받은 경기를 마친 자동차 객체 리스트로 승리 조건을 결정한다.
    - [ ] 가장 멀리 간 값
- [ ] 승리 조건에 부합하는 자동차 객체를 모은다.
    - [ ] 자동차 객체에서 자동차 이름으로 모은다.
- [ ] 승리 조건에 맞는 출력 값으로 변환하여 반환한다.
---
### 📁 racer

#### 🤵 RacerService
- [ ] 자동차 객체를 입력받아 움직임을 결정한다.
    - [ ] 특정 범위 사이의 무작위 숫자(엔진 토크)를 얻어낸다.
    - [ ] 엔진 토크가 특정 값 이상이라면 페달링을 한 것이라 생각한다.
    - [ ] 페달링이 있었다면 자동차 객체를 가속한다.

## 👀view

---


### 📁 Constant

**상수 값을 모아둘 곳**

#### 👀 Request
- [x] 자동차 이름 입력 안내 메시지
- [x] 시도할 횟수 입력 안내 메시지
#### 👀 Output
- [x] 실행 결과 안내 메시지
- [x] 자동차 객체 당 출력 메시지 포맷
- [x] LAP 마다 줄 바꿈 메시지
- [x] 최종 우승자 출력 포맷

### 👀 UserInput
- [x] 입력 안내 문구 출력한다.
- [x] 사용자의 입력을 받아 문자열을 반환한다.

### 👀 ScoreBoard
- [ ] 자동차 상태를 반환한다.
    - [ ] 자동차 이름을 입력 받는다.
    - [ ] 자동차 이동 거리(시각화 된)를 입력 받는다.
    - [ ] 특정한 포맷에 맞게 변환한 문자열을 반환한다.
- [ ] 승자를 반환한다.
    - [ ] 승자들이 적힌 문자열을 입력 받는다.
    - [ ] 특정한 포맷에 맞게 변환한 문자열을 반환한다.