# 미션 2 - 자동차 경주 게임

### 학습 목표

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- 1주 차 공통 피드백을 최대한 반영한다.
- `JUnit5`와 `AssertJ`에서 제공하는 함수들의 차이를 이해하며 사용한다.
- `Java Collections Framework`에 대해 학습하고 사용한다.
- `Value Object`와 `First Class Collection`에 대해 학습하고 사용한다.

## 문제 분석

> 초간단 자동차 경주 게임을 구현한다.

1. 입력값 처리
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용한다.
    - 자동차 이름을 입력받는다.
        - 쉼표(,)를 기준으로 구분한다.
        - 이름은 5자 이하만 가능하다.
        - 이름은 빈 문자열이 불가하다
        - 이름에는 특수문자가 포함될 수 없다.
    - 시도할 횟수를 입력받는다.
        - 양의 정수만 가능하다.
        - 100회 이상은 불가하다.
2. 출력값 처리
    - 각 시도마다 자동차의 이름과 위치를 출력한다.
        - 위치는 `-`로 표시한다.
            - ex) `pobi : --`
    - 마지막에 최종 우승자를 출력한다.
        - 우승자는 한 명 이상일 수 있다.
        - 우승자는 `, `로 구분한다.
            - ex) `pobi, jun`
3. 자동차의 이동
    - 0~9 사이의 랜덤값을 생성한다.
        - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 사용한다.
        - 4 이상일 경우 전진한다.

## 설계

먼저 구동되는 애플리케이션을 만들고 리팩토링을 진행한다. 클래스와 메소드를 분리 한 이후 테스트를 작성한다.

### Application

1. `Controller`의 `run()`을 실행한다.
2. 의존성들을 주입한다.

### Controller

1. `RacingCarController`
    - 로직을 처리한다.

### View

1. `InputView`
    - 사용자 입력을 받는 기능을 담당한다.
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
2. `OutputView`
    - 출력하는 기능을 담당한다.

### Validator

1. `InputValidator`
    - 입력값이 유효한지 검사하는 기능을 담당한다.
    - regex를 이용한다.

### Exception

1. `CarNameException`
    - 자동차 이름이 유효하지 않을 때 발생하는 예외
2. `TryCountException`
    - 시도 횟수가 유효하지 않을 때 발생하는 예외

### Value Object

1. `Name`
    - 자동차 이름을 저장한다.
    - 자동차 이름의 유효성을 검사한다.
2. `Position`
    - 자동차의 위치를 저장한다.
    - 자동차 위치의 유효성을 검사한다.
    - 자동차의 위치를 이동시킨다.

### Domain

1. `RacingCar`
    - 각각의 자동차에 대한 정보를 갖는다.
    - 자동차를 이동할 수 있게 한다.
2. `RacingCars`
    - 여러 대의 자동차에 대한 정보를 갖는다.
    - 일급 컬렉션으로 구현한다.
    - 자동차들을 이동시킨다.
    - 우승자를 판별한다.

### 클래스 다이어그램

<img width="700" alt="image" src="https://github.com/user-attachments/assets/688e1aed-bdca-48d7-9eb0-ca776f2e6e46">

### 기능 목록

- [ ] **자동차 이름 입력 및 검증**
    - [x] 쉼표(,)로 구분된 자동차 이름을 입력받는다.
    - [x] 각 자동차 이름은 5자 이하이어야 한다.
    - [ ] 이름이 빈 문자열이거나 특수문자를 포함하면 `CarNameException`을 발생시킨다.

- [ ] **시도 횟수 입력 및 검증**
    - [x] 시도할 횟수를 입력받는다.
    - [x] 시도 횟수는 1~99 사이의 양의 정수여야 한다.
    - [ ] 유효하지 않은 입력인 경우 `TryCountException`을 발생시킨다.

- [ ] **자동차 전진 여부 결정**
    - [ ] 0~9 사이의 무작위 숫자를 생성한다.
    - [ ] 숫자가 4 이상인 경우 자동차가 전진한다.

- [ ] **자동차 경주 실행**
    - [ ] 각 라운드마다 모든 자동차를 이동시킨다.
    - [ ] 매 라운드의 결과를 출력한다.
    - [ ] 자동차의 위치를 `-`로 표시한다.

- [ ] **우승자 판별**
    - [ ] 경주가 끝난 후 최종 우승자를 판별한다.
    - [ ] 여러 명의 우승자가 있을 경우 쉼표(,)로 구분해 출력한다.

- [ ] **출력**
    - [ ] 각 시도마다 자동차의 이름과 위치를 출력한다.
    - [ ] 최종 우승자를 출력한다.

- [ ] **테스트**
    - [ ] private이 아닌 메소드들의 단위 테스트를 작성한다.
    - [ ] `JUnit5`와 `AssertJ`를 사용한다.