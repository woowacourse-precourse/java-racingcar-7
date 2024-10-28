# java-racingcar-precourse
#  자동차 경주

# 🏎️ 자동차 경주 게임
자동차 경주 게임을 구현한 프로젝트입니다.

## 🎯 기능 요구사항
1. 사용자 입력
  - [ ] 쉼표(,)를 기준으로 구분하여 자동차 이름들을 입력받음
  - [ ] 시도할 횟수를 입력받음

2. 자동차 이름 검증
  - [ ] 이름은 5자 이하만 가능
  - [ ] 이름은 공백이 아니어야 함
  - [ ] 이름은 중복되지 않아야 함
  - [ ] 쉼표(,)로만 구분되어야 함
  - [ ] 입력의 마지막이 쉼표(,)로 끝나면 안됨

3. 시도 횟수 검증
  - [ ] 양의 정수만 입력 가능
  - [ ] 숫자 형식이어야 함

4. 게임 진행
  - [ ] 0에서 9 사이의 무작위 값을 구함
  - [ ] 무작위 값이 4 이상일 경우 전진
  - [ ] 무작위 값이 3 이하일 경우 정지
  - [ ] 각 차수별 실행 결과 출력

5. 우승자 판정
  - [ ] 가장 멀리 이동한 자동차가 우승
  - [ ] 동일한 거리의 자동차가 여러 대일 경우 공동 우승
  - [ ] 우승자 이름을 쉼표(,)로 구분하여 출력

## 🏗️ 프로젝트 구조
```
src
├── main/java/racingcar
│   ├── controller
│   │   └── GameController.java
│   ├── domain
│   │   ├── Car.java
│   │   └── Race.java
│   ├── validation
│   │   └── InputValidator.java
│   ├── view
│   │   └── ConsoleView.java
│   ├── Application.java
│   └── Constants.java
└── test/java/racingcar
    ├── controller
    │   └── GameControllerTest.java
    ├── domain
    │   ├── CarTest.java
    │   └── RaceTest.java
    ├── validation
    │   └── InputValidatorTest.java
    └── ApplicationTest.java
```

## 🚀 기술 스택
- Java 21
- JUnit 5
- AssertJ
- Mockito

## 📝 프로그래밍 요구사항
1. Java 코드 컨벤션을 지키면서 프로그래밍
2. indent(인덴트, 들여쓰기) depth를 2까지만 허용
3. 3항 연산자 사용 금지
4. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 작성
5. JUnit 5와 AssertJ를 이용하여 테스트 코드 작성
6. camp.nextstep.edu.missionutils 패키지의 Randoms, Console 클래스 활용