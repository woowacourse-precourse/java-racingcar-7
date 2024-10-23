# java-racingcar-precourse

# MVC 패턴에 따른 디렉토리 구조
```
racing-car-game/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── racingcar/
│   │   │       ├── Application/
│   │   │       ├── controller/
│   │   │       │   └── GameController.java
│   │   │       ├── domain/
│   │   │       │   ├── Car.java
│   │   │       │   ├── Race.java
│   │   │       │   └── strategy/
│   │   │       │       ├── MovableStrategy.java
│   │   │       │       └── RandomMovableStrategy.java
│   │   │       ├── view/
│   │   │       │   ├── InputView.java
│   │   │       │   └── OutputView.java
│   │   │       ├── validator/
│   │   │       │   ├── InputValidator.java
│   │   │       │   └── CarNameValidator.java
│   │   │       └── exception/
│   │   │           ├── InvalidCarNameException.java
│   │   │           ├── InvalidInputException.java
│   │   │           └── RaceNotStartedException.java
│   │   └── resources/
│
├── test/
│   ├── java/
│   │   ├── racingcar/
│   │   │   └── ApplicationTest/
│
└── build.gradle
```

# 구현 기능 목록

--- 
## controller
- 게임의 흐름을 제어하고, 입출력을 처리하는 클래스.

## domain
- Car.java : 자동차의 상태와 동작을 정의한 클래스
- Race.java : 자동차 경주의 진행을 제어하는 클래스

## domain - strategy
- MovableStrategy.java: 자동차의 전진 여부를 결정하는 전략 인터페이스
- RandomMovableStrategy.java: 무작위 값으로 자동차의 전진 여부를 결정하는 구현체

## view
- InputView.java: 사용자로부터 입력을 받는 클래스.
- OutputView.java: 게임 결과와 진행 상황을 출력하는 클래스.

## validator
- InputValidator.java: 입력 값의 유효성을 검증하는 클래스.
- CarNameValidator.java: 자동차 이름의 유효성을 검증하는 클래스.

## exception
- InvalidCarNameException.java: 잘못된 자동차 이름 입력 시 발생하는 예외.
- InvalidInputException.java: 잘못된 사용자 입력 시 발생하는 예외.